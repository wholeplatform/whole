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

import java.awt.image.BufferedImage;
import java.io.Reader;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;

public class SVGUtils {
	public static BufferedImage toBufferedImage(Reader reader) throws TranscoderException {
		return toBufferedImage(new TranscoderInput(reader));
	}
	public static BufferedImage toBufferedImage(Reader reader, float width) throws TranscoderException {
		return toBufferedImage(new TranscoderInput(reader), width);
	}

	public static BufferedImage toBufferedImage(TranscoderInput input) throws TranscoderException {
		return toBufferedImage(input, Float.NaN);
	}
	public static BufferedImage toBufferedImage(TranscoderInput input, float width) throws TranscoderException {
		IdentityImageTranscoder transcoder = new IdentityImageTranscoder();
		if (!Float.isNaN(width))
			transcoder.addTranscodingHint(ImageTranscoder.KEY_WIDTH, width);
		transcoder.transcode(input, null);
		return transcoder.getImage();
	}

	public static class IdentityImageTranscoder extends ImageTranscoder {
		private BufferedImage image;
		public BufferedImage getImage() {
			return image;
		}		
		@Override
		public BufferedImage createImage(int w, int h) {
			return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		}
		@Override
		public void writeImage(BufferedImage image, TranscoderOutput output) throws TranscoderException {
			this.image = image;
		}
	}
}
