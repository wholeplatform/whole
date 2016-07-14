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

import static org.whole.lang.ui.image.SVGUtils.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.whole.lang.ui.image.ICNSGenerator;
import org.whole.lang.ui.image.ICOGenerator;
import org.whole.lang.ui.image.IImageGenerator;
import org.whole.lang.ui.image.SplashBMPGenerator;
import org.whole.lang.ui.image.XPMGenerator;
import org.whole.lang.util.StringUtils;

/**
 * Launch as Eclipse application using the following options:
 * 
 * Main Tab			> Run an Application:	org.whole.lang.ui.image.ImagesGenerator
 * Arguments Tab	> VM Arguments:			-Djava.awt.headless=true 
 * Arguments Tab	> Working Directory:	${workspace_loc:org.whole.test}
 */
public class ImagesGenerator implements IApplication {
	public Reader getSplResource(String name) throws IOException {
		String path = "../../whole-spl/org.whole.releng.langs/icons/"+name;
		return new InputStreamReader(new FileInputStream(path), "utf-8");
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		try (Reader reader = getSplResource("splash_as.svg");
				OutputStream osIncubator = new FileOutputStream("../../whole-apps/com.whole.product.incubator/splash.bmp");
				OutputStream osOtik = new FileOutputStream("../../whole-apps/com.whole.product.otik/splash.bmp")) {
			IImageGenerator generator = new SplashBMPGenerator();
			generator.addImage(toBufferedImage(reader));
			generator.write(osIncubator);
			generator.write(osOtik);
		}

		try (Reader reader = getSplResource("splash_lw.svg");
				OutputStream os = new FileOutputStream("../../whole/org.whole.product.lw/splash.bmp")) {
			IImageGenerator generator = new SplashBMPGenerator();
			generator.addImage(toBufferedImage(reader));
			generator.write(os);
		}

		try (Reader reader16 = getSplResource("whole16.svg");
				Reader reader32 = getSplResource("whole32.svg");
				Reader reader64 = getSplResource("whole64.svg");
				Reader reader128 = getSplResource("whole128.svg");
				OutputStream osIncubator = new FileOutputStream("../../whole-apps/com.whole.product.incubator.product/whole.icns");
				OutputStream osOtik = new FileOutputStream("../../whole-apps/com.whole.product.otik.product/whole.icns");
				OutputStream osLw = new FileOutputStream("../../whole/org.whole.product.lw.product/whole.icns");
				OutputStream osE4Lw = new FileOutputStream("../../whole/org.whole.product.e4.lw.product/whole.icns")) {

			String whole128 = StringUtils.readAsString(reader128);

			IImageGenerator generator = new ICNSGenerator();
			generator.addImage(toBufferedImage(reader16, 16));
			generator.addImage(toBufferedImage(reader32, 32));
			generator.addImage(toBufferedImage(reader64, 64));
			generator.addImage(toBufferedImage(new StringReader(whole128), 128));
			generator.addImage(toBufferedImage(new StringReader(whole128), 256));
			generator.addImage(toBufferedImage(new StringReader(whole128), 512));
			generator.addImage(toBufferedImage(new StringReader(whole128), 1024));
	
			generator.write(osIncubator);
			generator.write(osOtik);
			generator.write(osLw);
			generator.write(osE4Lw);
		}

		try (Reader reader16 = getSplResource("whole16.svg");
				Reader reader32 = getSplResource("whole32.svg");
				Reader reader64 = getSplResource("whole64.svg");
				Reader reader128 = getSplResource("whole128.svg");
				OutputStream osIncubator = new FileOutputStream("../../whole-apps/com.whole.product.incubator.product/whole.ico");
				OutputStream osOtik = new FileOutputStream("../../whole-apps/com.whole.product.otik.product/whole.ico");
				OutputStream osLw = new FileOutputStream("../../whole/org.whole.product.lw.product/whole.ico");
				OutputStream osE4Lw = new FileOutputStream("../../whole/org.whole.product.e4.lw.product/whole.ico")) {


			IImageGenerator generator = new ICOGenerator();
			generator.addImage(toBufferedImage(reader16, 16));
			generator.addImage(toBufferedImage(reader32, 32));
			generator.addImage(toBufferedImage(reader64, 48));
			generator.addImage(toBufferedImage(reader128, 256));
	
			generator.write(osIncubator);
			generator.write(osOtik);
			generator.write(osLw);
			generator.write(osE4Lw);
		}

		try (Reader reader128 = getSplResource("whole128.svg");
				OutputStream osIncubator = new FileOutputStream("../../whole-apps/com.whole.product.incubator.product/whole.xpm");
				OutputStream osOtik = new FileOutputStream("../../whole-apps/com.whole.product.otik.product/whole.xpm");
				OutputStream osLw = new FileOutputStream("../../whole/org.whole.product.lw.product/whole.xpm");
				OutputStream osE4Lw = new FileOutputStream("../../whole/org.whole.product.e4.lw.product/whole.xpm")) {

			IImageGenerator generator = new XPMGenerator();
			generator.addImage(toBufferedImage(reader128, 256));
	
			generator.write(osIncubator);
			generator.write(osOtik);
			generator.write(osLw);
			generator.write(osE4Lw);
		}
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		
	}
}
