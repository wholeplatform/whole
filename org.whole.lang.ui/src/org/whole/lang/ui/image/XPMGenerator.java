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
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class XPMGenerator extends AbstractImageGenerator {
	private static final int RGB_ALPHA = 0xFF000000;

	public void write(OutputStream os) throws IOException {
		Iterator<RenderedImage> iterator = images.values().iterator();
		if (!iterator.hasNext())
			throw new IllegalArgumentException("no image provided");

		ImageData image = new ImageData(iterator.next());
		try (OutputStreamWriter writer = new OutputStreamWriter(os, "ascii")) {
			writer.append("/* XPM */\nstatic char * blarg_xpm[] = {\n");

			writeGeometry(writer, image);
			writePalette(writer, image);
			writePixels(writer, image);

			writer.append("};\n");
		}
	}

	protected void writeGeometry(Writer writer, ImageData image) throws IOException {
		writer.append(String.format("\"%d %d %d %d\",\n", 
				image.getWidth(), image.getHeight(),
				image.getColorsNumber(), image.getPixelDepth()));
	}

	protected void writePalette(Writer writer, ImageData image) throws IOException {
		Map<Integer, String> colorMap = image.getColorMap();
		for (Entry<Integer, String> entry : colorMap.entrySet()) {
			String color = entry.getKey() == RGB_ALPHA ? "None" : String.format("#%06X", entry.getKey());
			writer.append(String.format("\"%s\tc %s\",\n", entry.getValue(), color));
		}
	}

	protected void writePixels(Writer writer, ImageData image) throws IOException {
		for (int y = 0; y < image.getHeight(); y++) {
			writer.append("\"");

			for (int x = 0; x < image.getWidth(); x++)
				writer.append(image.getPixelData(x, y));

			writer.append("\",\n");
		}
	}

	public static final class ImageData {
		private static final char[] DIGITS = " .+@#$%&*=-;>,')!~{]^/(_:<[}|1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`".toCharArray();

		protected Map<Integer, String> colorMap;
		protected String[][] pixels;
		protected int pixelDepth;

		public ImageData(RenderedImage image) {
			Raster raster = image.getData();
			ColorModel colorModel = image.getColorModel();

			this.colorMap = new TreeMap<Integer, String>();

			int width = image.getWidth();
			int height = image.getHeight();

			Set<Integer> colors = new HashSet<>();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					Object dataElements = raster.getDataElements(x, y, null);
					int rgb = colorModel.getRGB(dataElements) & ~RGB_ALPHA;
					if (colorModel.getAlpha(dataElements) < 127)
						rgb = RGB_ALPHA;

					colors.add(rgb);
				}
			}
			
			pixelDepth = 0;
			int colorCount = colors.size();
			while (colorCount > 0) {
				colorCount /= DIGITS.length;
				pixelDepth +=1;
			}

			this.pixels = new String[height][];
			for (int y = 0; y < pixels.length; y++) {
				this.pixels[y] = new String[width];
				for (int x = 0; x < pixels[y].length; x++) {
					Object dataElements = raster.getDataElements(x, y, null);
					int rgb = colorModel.getRGB(raster.getDataElements(x, y, null)) & ~RGB_ALPHA;
					if (colorModel.getAlpha(dataElements) < 127)
						rgb = RGB_ALPHA;

					this.pixels[y][x] = calculatePixelData(rgb);
				}
			}
		}
		protected String calculatePixelData(int rgb) {
			String pixel = colorMap.get(rgb);
			if (pixel == null)
				colorMap.put(rgb, pixel = toPixel(getColorsNumber()));
			return pixel;
		}
		protected String toPixel(int pixel) {
			char buffer[] = new char[pixelDepth];
			Arrays.fill(buffer, 0, pixelDepth, DIGITS[0]);

			int index = 0;
			while (pixel >= DIGITS.length) {
				buffer[index++] = DIGITS[pixel % DIGITS.length];
				pixel = pixel / DIGITS.length;
			}
			buffer[index] = DIGITS[pixel];

			return String.valueOf(buffer, 0, index+1);
		}
		
		public String getPixelData(int x, int y) {
			return this.pixels[y][x];
		}

		public Map<Integer, String> getColorMap() {
			return Collections.unmodifiableMap(colorMap);
		}

		public int getColorsNumber() {
			return colorMap.size();
		}

		public int getPixelDepth() {
			return this.pixelDepth;
		}

		public int getWidth() {
			return getHeight() > 0 ? pixels[0].length : 0;
		}
		public int getHeight() {
			return pixels.length;
		}
	}
}

