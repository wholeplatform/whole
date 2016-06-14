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

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileCacheImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class ICNSGenerator extends AbstractImageGenerator {
	private static final String ICNS_MAGIC = "icns";
	private static final int HEADER_LENGTH = 8;

	public void write(OutputStream os) throws IOException {
		List<ICNSData> icons = new ArrayList<>();
		for (ICNSType iconType : ICNSType.values()) {
			RenderedImage image = images.get(iconType.getSize());
			if (image == null)
				throw new IllegalArgumentException("incomplete image dimesions");
			
			icons.add(new ICNSData(iconType, image));
		}

		try (FileCacheImageOutputStream ios = new FileCacheImageOutputStream(os, null)) {
			ios.setByteOrder(ByteOrder.BIG_ENDIAN);
			
			writeHeader(ios, ICNS_MAGIC, calculateTotalLength(icons));
			for (ICNSData icon : icons)
				writeSegments(ios, icon);
		}
	}

	protected void writeHeader(ImageOutputStream ios, String magic, int length) throws IOException {
		ios.writeBytes(magic);
		ios.writeInt(length);
	}
	protected void writeSegments(ImageOutputStream ios, ICNSData iconData) throws IOException {
		ICNSType iconType = iconData.getIconType();

		// write icon data
		writeHeader(ios, iconType.getMagic(), iconData.getImage().length + HEADER_LENGTH);
		ios.write(iconData.getImage());

		// conditional write icon alpha
		if (iconType.hasAlpha()) {
			writeHeader(ios, iconType.getAlphaMagic(), iconData.getAlpha().length + HEADER_LENGTH);
			ios.write(iconData.getAlpha());
		}
	}
	protected int calculateTotalLength(List<ICNSData> icons) {
		int length = HEADER_LENGTH; // main header size
		for (ICNSData iconData : icons) {
			length += HEADER_LENGTH; // icon header size
			length += iconData.getImage().length; // icon data size
			if (iconData.getIconType().hasAlpha()) {
				length += HEADER_LENGTH; // icon header size
				length += iconData.getAlpha().length; // icon data size
			}
		}
		return length;
	}

	protected BufferedImage halfScale(BufferedImage image) {
		int w = image.getWidth() / 2;
		int h = image.getHeight() / 2;
		BufferedImage scaled = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.scale(.5, .5);
		AffineTransformOp operation = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BICUBIC);
		return operation.filter(image, scaled);
	}
}
