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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.PipeBracketsBorder;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class InlinePointFigure extends EntityFigure {
	public InlinePointFigure() {
		super(new MonoLayout().withMargin(1));

		setBorder(new PipeBracketsBorder(3) {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(ColorConstants.gray);
				g.setLineWidth(1);
				g.setLineStyle(SWT.LINE_CUSTOM);
				g.setLineDash(new int[] {3,2});
			}
		});
	}
}
