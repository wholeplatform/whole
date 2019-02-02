/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.misc.ui.editparts;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class MiscPart extends CompositeColumnWithPlaceholderPart {
    protected IFigure createFigure() {
        return new CompositeFigure(new ColumnLayout().withSpacing(7).withMargin(5)) {
            @Override
            protected void paintFigure(Graphics graphics) {
                super.paintFigure(graphics);

                graphics.setForegroundColor(FigureConstants.lightGray);
                graphics.setLineWidthFloat(1.2f);
                graphics.setLineStyle(SWT.LINE_CUSTOM);
                graphics.setLineDash(new int[] {5,3});

    			List<IFigure> children = getChildren();
    			for (int i=0; i<children.size(); i++) {
    				graphics.drawRectangle(children.get(i).getBounds().getExpanded(1, 1));
    			}
            }
        };
    }
}
