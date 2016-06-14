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

import static org.junit.Assert.*;
import static org.whole.lang.ui.image.SVGUtils.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;
import org.whole.lang.ui.image.ICNSGenerator;
import org.whole.lang.ui.image.ICOGenerator;
import org.whole.lang.ui.image.IImageGenerator;
import org.whole.lang.ui.image.SplashBMPGenerator;
import org.whole.lang.ui.image.XPMGenerator;

/**
 * run in headless adding "-Djava.awt.headless=true" as VM argument 
 */
public class ImagesGeneratorTest {

	@Test
	public void testSplash() throws Exception {
		IImageGenerator generator = new SplashBMPGenerator();
		Reader reader = new InputStreamReader(getClass().getResourceAsStream("images/splash.svg"), "utf-8");
		generator.addImage(toBufferedImage(reader));
		reader.close();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		generator.write(os);

		assertThat(os.toByteArray(), equalTo(readAllBytes("images/splash.bmp")));
	}

	@Test
	public void testICNS() throws Exception {
		IImageGenerator generator = new ICNSGenerator();
		int[] icnsWidths = { 16, 32, 64, 128, 256, 512, 1024 };
		for (int width : icnsWidths) {
			Reader reader = new InputStreamReader(getClass().getResourceAsStream("images/whole.svg"), "utf-8");
			generator.addImage(toBufferedImage(reader, width));
			reader.close();
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		generator.write(os);

		assertThat(os.toByteArray(), equalTo(readAllBytes("images/whole.icns")));
	}

	@Test
	public void testICO() throws Exception {
		IImageGenerator generator = new ICOGenerator();
		int[] icoWidths = { 16, 32, 48, 256 };
		for (int width : icoWidths) {
			Reader reader = new InputStreamReader(getClass().getResourceAsStream("images/whole.svg"), "utf-8");
			generator.addImage(toBufferedImage(reader, width));
			reader.close();
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		generator.write(os);

		assertThat(os.toByteArray(), equalTo(readAllBytes("images/whole.ico")));
	}

	@Test
	public void testXPM() throws Exception {
		IImageGenerator generator = new XPMGenerator();
		Reader reader = new InputStreamReader(getClass().getResourceAsStream("images/whole.svg"), "utf-8");
		generator.addImage(toBufferedImage(reader, 256));
		reader.close();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		generator.write(os);

		assertThat(os.toByteArray(), equalTo(readAllBytes("images/whole.xpm")));
	}

	public byte[] readAllBytes(String resourceName) throws IOException {
		return readAllBytes(getClass().getResourceAsStream(resourceName));
	}
	public static byte[] readAllBytes(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] buffer = new byte[1024];
		int length;

		while ((length = bis.read(buffer)) > 0)
			baos.write(buffer, 0, length);
		return baos.toByteArray();
	}
}
