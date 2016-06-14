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

import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileCacheImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import com.github.jaiimageio.impl.common.PaletteBuilder;

public class ICOGenerator extends AbstractDIBGenerator {
	private static final byte[] ICO_MAGIC = { 0, 0 , 1, 0 };	
	private static final int BYTE_MASK = 0xFF;

	private static final int ICONDIR_SIZE = 6;
	private static final int ICONDIRENTRY_SIZE = 16;

	public void write(OutputStream os) throws IOException {
		List<RenderedImage> icons = new ArrayList<>();
		for (ICOType iconType : ICOType.values()) {
			RenderedImage image = images.get(iconType.getSize());
			if (image == null)
				throw new IllegalArgumentException("incomplete image dimesions");

			icons.add(iconType.isIndexed() ? PaletteBuilder.createIndexedImage(image) : image);
		}

		try (ImageOutputStream ios = new FileCacheImageOutputStream(os, null)) {
			ios.setByteOrder(ByteOrder.LITTLE_ENDIAN);

			ios.write(ICO_MAGIC);
			ios.writeShort(icons.size());

			int offset = calculateIconHeaderSize(icons.size());
			for (RenderedImage image : icons)
				offset = writeIconDirEntry(ios, image, offset);

			for (RenderedImage image : icons)
				writeIconImage(ios, image, true);
		}
	}

	protected int calculateIconHeaderSize(int iconNumber) {
		return ICONDIR_SIZE + ICONDIRENTRY_SIZE * iconNumber;
	}

	protected int writeIconDirEntry(ImageOutputStream ios, RenderedImage image, int offset) throws IOException {
		ios.writeByte(image.getWidth() & BYTE_MASK);
		ios.writeByte(image.getHeight() & BYTE_MASK);

		ios.writeShort(0);
		ios.writeShort(1);
		ios.writeShort(image.getColorModel().getPixelSize());

		int size = calculateIconImageSize(image);
		ios.writeInt(size);
		ios.writeInt(offset);

		return offset + size;
	}

	protected int calculateIconImageSize(RenderedImage image) {
		int pixelBytes = image.getColorModel().getPixelSize() / 8;
		int width = image.getWidth();
		int height = image.getHeight();

		int rowWidth = roundToMultipleOfFour(width * pixelBytes);
		int maskWidth = roundToMultipleOfFour((width + 7) / 8);
		return BITMAPINFOHEADER_SIZE + 
				(pixelBytes == 1 ? 1024 : 0) +
				rowWidth * height +
				maskWidth * height;
	}

	protected int calculateBitDepth(RenderedImage image) {
		return image.getColorModel().getPixelSize();
	}

	protected void writeImage(ImageOutputStream ios, RenderedImage image, Map<Integer, Integer> mappings) throws IOException {
		int pixelBytes = image.getColorModel().getPixelSize() / 8;
		int width = image.getWidth();
		int height = image.getHeight();
		int rowWidth = roundToMultipleOfFour(width * pixelBytes);

		Raster raster = image.getData();
		for (int y = height-1; y >= 0; y--) {
			for (int x = 0; x < width; x++) {
				if (pixelBytes == 1) {
					byte[] dataElements = (byte[]) raster.getDataElements(x, y, null);
					int index = mappings.get(((int) dataElements[0]) & 0xFF);
					ios.write(index);
				} else {
					int rgba = image.getColorModel().getRGB(raster.getDataElements(x, y, null));
					ios.writeInt(rgba);
				}
			}
			if (pixelBytes == 1)
				for (int i = width; i < rowWidth; i++)
					ios.write(0);
		}
	}

	protected int calculateHeight(RenderedImage image) {
		return super.calculateHeight(image) * 2;
	}
	protected int calculateSize(RenderedImage image) {
		return 0;
	}
}
