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
package org.whole.product.lw.ui.splash;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.branding.IProductConstants;
import org.eclipse.ui.splash.BasicSplashHandler;

/**
 * @author Enrico Persiani
 */
public class LanguageWorkbenchSplashHandler extends BasicSplashHandler {

	public void init(Shell splash) {
		super.init(splash);

		IProduct product = Platform.getProduct();
		if (product == null) {
			getContent();
			return;
		}

		String progressPosition = product.getProperty(IProductConstants.STARTUP_PROGRESS_RECT);
		setProgressRect(StringConverter.asRectangle(progressPosition, new Rectangle(0, 0, 300, 15)));

		String messagePosition = product.getProperty(IProductConstants.STARTUP_MESSAGE_RECT);
		setMessageRect(StringConverter.asRectangle(messagePosition, new Rectangle(0, 35, 300, 15)));

		String foreground = product.getProperty(IProductConstants.STARTUP_FOREGROUND_COLOR);
		int foregroundColor;
		try {
			foregroundColor = Integer.parseInt(foreground, 16);
		} catch (NumberFormatException e) {
			foregroundColor = 0xD2D7FF; // off white
		}
		setForeground(new RGB((foregroundColor & 0xFF0000) >> 16, (foregroundColor & 0xFF00) >> 8, foregroundColor & 0xFF));


		getContent().addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.setForeground(getForeground());
				e.gc.drawText(Platform.getBundle("org.whole.product.lw").getVersion().toString(), 250, 52, true);
			}
		});
	}
}
