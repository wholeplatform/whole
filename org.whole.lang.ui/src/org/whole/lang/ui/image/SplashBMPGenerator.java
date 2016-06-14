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
import java.util.Map;

import javax.imageio.stream.FileCacheImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class SplashBMPGenerator extends AbstractDIBGenerator {
	private static final int SPLASH_WIDTH = 500;
	private static final int SPLASH_HEIGHT = 330;
	private static final int BMP_MAGIC = 0x4D42;
	private static final int BMP_HEADER_SIZE = 0x36;

	public void write(OutputStream os) throws IOException {
		RenderedImage image = images.get(SPLASH_WIDTH);
		if (image == null || image.getHeight() != SPLASH_HEIGHT)
			throw new IllegalArgumentException("unsupported splash dimensions");
		else if (image.getColorModel().getPixelSize() != 32)
			throw new IllegalArgumentException("unsupported pixel size");

		try (ImageOutputStream ios = new FileCacheImageOutputStream(os, null)) {
			ios.setByteOrder(ByteOrder.LITTLE_ENDIAN);

			ios.writeShort(BMP_MAGIC);

			int imageSize = calculateBMPImageSize(image);
			ios.writeInt(BMP_HEADER_SIZE+imageSize);
			ios.writeInt(0);
			ios.writeInt(BMP_HEADER_SIZE);

			writeIconImage(ios, image, false);
		}
	}

	protected int calculateBMPImageSize(RenderedImage image) {
		int pixelBytes = calculateBitDepth(image) / 8;
		int width = image.getWidth();
		int height = image.getHeight();

		return width * height * pixelBytes;
	}

	protected int calculateBitDepth(RenderedImage image) {
		return 24;
	}

	protected void writeImage(ImageOutputStream ios, RenderedImage image, Map<Integer, Integer> mappings) throws IOException {
		int width = image.getWidth();
		int height = image.getHeight();

		Raster raster = image.getData();
		for (int y = height-1; y >= 0; y--) {
			for (int x = 0; x < width; x++) {
				int rgba = image.getColorModel().getRGB(raster.getDataElements(x, y, null));
				int alpha = (rgba >> 24) & 0xFF;
				ios.write((byte) ((rgba & 0xFF) * alpha / 0xFF));
				ios.write((byte) (((rgba >> 8) & 0xFF) * alpha / 0xFF));
				ios.write((byte) (((rgba >> 16) & 0xFF) * alpha / 0xFF));
			}
		}
	}

	@Override
	protected int calculateSize(RenderedImage image) {
		return calculateBMPImageSize(image);
	}
}
