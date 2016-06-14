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

import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class ICNSData {
	protected ICNSType iconType;
	protected byte[] image;
	protected byte[] alpha;

	public ICNSData(ICNSType iconType, RenderedImage image) throws IOException {
		if (image.getWidth() != image.getHeight() || image.getWidth() != iconType.getSize())
			throw new IllegalArgumentException(String.format("invalid image size: %dx%d", image.getWidth(), image.getHeight()));

		this.iconType = iconType;
		this.image = encodeImage(iconType, image);
		this.alpha = iconType.hasAlpha() ? encodeAlpha(iconType, image) : null;
	}

	public ICNSType getIconType() {
		return iconType;
	}
	public byte[] getImage() {
		return image;
	}
	public byte[] getAlpha() {
		return alpha;
	}

	protected byte[] encodeImage(ICNSType iconType, RenderedImage image) throws IOException {
		switch (iconType) {
		case IC08:
		case IC09:
		case IC10:
		case IC11:
		case IC12:
		case IC13:
		case IC14:
			return convertToPng(image);

		case IS32:
		case IL32:
		case IT32:
		default:
			return convertToRaw(iconType, image);
		}
	}

	protected byte[] encodeAlpha(ICNSType iconType, RenderedImage image) {
		return convertToAlpha(image);
	}

	protected byte[] convertToPng(RenderedImage image) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		return baos.toByteArray();
	}

	private static class Component {
		private List<Byte> values;
		private int repetitions;

		public Component(byte value, int repetitions) {
			this.values = new ArrayList<Byte>();
			this.values.add(value);
			this.repetitions = repetitions;
		}
		public Component(byte value) {
			this(value, 0);
		}
		public Component add(byte value) {
			if (repetitions == 0) {
				int size = values.size();
				if (size < 2 || values.get(size-2) != value || values.get(size-1) != value) {
					if (size < 128) {
						values.add(value);
						return null;
					} else
						return new Component(value);
				} else {
					if (size == 2) {
						values.remove(size-1);
						this.repetitions = 3;
						return null;
					} else {
						values.remove(size-1);
						values.remove(size-2);
						return new Component(value, 3);
					}
				}
			} else {
				if (values.get(0) != value || repetitions == 130) {
					return new Component(value);
				} else {
					repetitions += 1;
					return null;
				}
			}
		}
		public int getSize() {
			return repetitions == 0 ? values.size() + 1 : 2;
		}
		public byte[] toByteArray() {
			byte[] bytes = new byte[getSize()];
			if (repetitions == 0) {
				int size = values.size();
				bytes[0] = (byte) (size - 1);
				for (int i = 0; i < size; i++)
					bytes[i+1] = values.get(i);
			} else {
				bytes[0] = (byte) (repetitions + 125);
				bytes[1] = values.get(0);
			}
			return bytes;
		}
	}
	private static class Components {
		private LinkedList<Component> components = new LinkedList<Component>();
		public void add(byte value) {
			Component last = components.peekLast();
			Component fresh = last == null ?
					new Component(value) : last.add(value);
			if (fresh != null)
				components.add(fresh);
		}
		private byte[] toByteArray() {
			int length = 0;
			for (Component component : components)
				length += component.getSize();
			byte[] buffer = new byte[length];
			int offset = 0;
			for (Component component : components) {
				byte[] array = component.toByteArray();
				System.arraycopy(array, 0, buffer, offset, array.length);				
				offset += array.length;
			}
			return buffer;
		}
	}

	protected byte[] convertToRaw(ICNSType iconType, RenderedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();

		Components reds = new Components();
		Components greens = new Components();
		Components blues = new Components();

		Raster raster = image.getData();
		ColorModel colorModel = image.getColorModel();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int rgb = colorModel.getRGB(raster.getDataElements(x, y, null));
				reds.add((byte) ((rgb >> 16) & 0xFF));
				greens.add((byte) ((rgb >> 8) & 0xFF));
				blues.add((byte) (rgb & 0xFF));
			}
		}
		byte[] redArray = reds.toByteArray();
		byte[] greenArray = greens.toByteArray();
		byte[] blueArray = blues.toByteArray();
		int offset = iconType == ICNSType.IT32 ? 4 : 0;
		byte[] result = new byte[offset + redArray.length + greenArray.length + blueArray.length];
		System.arraycopy(redArray, 0, result, offset, redArray.length);
		System.arraycopy(greenArray, 0, result, offset + redArray.length, greenArray.length);
		System.arraycopy(blueArray, 0, result, offset + redArray.length + greenArray.length, blueArray.length);
		return result;
	}

	protected byte[] convertToAlpha(RenderedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		Raster raster = image.getData();
		ColorModel colorModel = image.getColorModel();

		byte[] alpha = new byte[width * height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int offset = (x + width * y);
				alpha[offset] = (byte) colorModel.getAlpha(raster.getDataElements(x, y, null));
			}
		}
		return alpha;
	}
}
