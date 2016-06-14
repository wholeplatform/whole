/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.ui.image;

import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.stream.ImageOutputStream;

public abstract class AbstractDIBGenerator extends AbstractImageGenerator {
	public static final int BITMAPINFOHEADER_SIZE = 40;

	protected void writeIconImage(ImageOutputStream ios, RenderedImage image, boolean withMask) throws IOException {
		ios.writeInt(BITMAPINFOHEADER_SIZE);
		ios.writeInt(calculateWidth(image));
		ios.writeInt(calculateHeight(image));

		int pixelSize = calculateBitDepth(image);
		ios.writeShort(1);
		ios.writeShort(pixelSize);

		ios.writeInt(0); // compression
		ios.writeInt(calculateSize(image)); // image size 
		ios.writeInt(0); // x pixels/meter
		ios.writeInt(0); // y pixels/meter
		ios.writeInt(0); // colors used
		ios.writeInt(0); // colors important

		Map<Integer, Integer> mappings = writeColorTable(ios, image);
		writeImage(ios, image, mappings);
		if (withMask)
			writeMask(ios, image);
	}

	protected abstract int calculateBitDepth(RenderedImage image);

	protected int calculateWidth(RenderedImage image) {
		return image.getWidth();
	}
	protected int calculateHeight(RenderedImage image) {
		return image.getHeight();
	}

	protected abstract int calculateSize(RenderedImage image);

	protected int roundToMultipleOfFour(int value) {
		return (value + 3) & (~ 3);
	}

	public static int[] processPalette(int[] palette, Map<Integer, Integer> mappings) throws IOException {
		int[] sorted = new int[palette.length];
		for (int i = 0; i < sorted.length; i++)
			palette[i] = sorted[i] = palette[i] & 0x00FFFFFF;

		Arrays.sort(sorted);
		int blackCount = 0;
		for (int i = 0; i < sorted.length; i++) {
			if (sorted[i] == 0)
				blackCount += 1;
			else
				break;
		}

		if (blackCount > 0) {
			int[] translated = new int[sorted.length - blackCount];
			System.arraycopy(sorted, blackCount, translated, 0, sorted.length - blackCount);
			sorted = translated;
		}
		
		if (mappings != null) {
			for (int i = 0; i < palette.length; i++) {
				int color = palette[i];
				int offset = Arrays.binarySearch(sorted, color);
				mappings.put(i, color == 0 ? sorted.length : offset);
			}
			
		}

		return sorted;
	}

	protected Map<Integer, Integer> writeColorTable(ImageOutputStream ios, RenderedImage image) throws IOException {
		Map<Integer, Integer> mappings = new HashMap<Integer, Integer>();

		int pixelSize = calculateBitDepth(image);
		if (pixelSize != 8)
			return mappings;

		IndexColorModel colorModel = (IndexColorModel) image.getColorModel();
		int mapSize = colorModel.getMapSize();
		int[] rgbs = new int[mapSize];
		colorModel.getRGBs(rgbs);

		int[] sorted = processPalette(rgbs, mappings);

		for (int i = 0, colors = 1 << pixelSize; i < colors; i++)
			ios.writeInt(i < sorted.length ? sorted[i] : 0x0);
		
		return mappings;
	}

	protected abstract void writeImage(ImageOutputStream ios, RenderedImage image, Map<Integer, Integer> mappings) throws IOException;

	protected void writeMask(ImageOutputStream ios, RenderedImage image) throws IOException {
		int width = image.getWidth();
		int height = image.getHeight();
		int maskSize = roundToMultipleOfFour((width+7)/8);

		Raster raster = image.getData();
		for (int y = height-1; y >= 0; y--) {
			BitStream stream = new BitStream(width);
			for (int x = 0; x < width; x++) {
				Object dataElements = raster.getDataElements(x, y, null);
				int alpha = image.getColorModel().getAlpha(dataElements);
				stream.set(alpha < 127);
			}
			// write mask
			byte[] bytes = stream.toByteArray();
			ios.write(bytes);

			// write padding
			for (int i = bytes.length; i < maskSize; i++)
				ios.write(0);
		}
	}

	public static class BitStream {
		protected int bitNum;
		protected byte[] bytes;
		protected int position;

		public BitStream(int bitNum) {
			this.bitNum = bitNum;
			this.bytes = new byte[(bitNum+7)/8];
		}

		public void set(boolean value) {
			int index = position / 8;
			bytes[index] = (byte) ((bytes[index] << 1) | (value ? 0x01 : 0x00));
			position++;
			
			if (position == bitNum)
				bytes[index] = (byte) (bytes[index] << (bytes.length * 8 - position));
		}
		
		public byte[] toByteArray() {
			if (position != bitNum)
				throw new IllegalStateException("not enough bits");

			return Arrays.copyOf(bytes, bytes.length);
		}
	}
}
