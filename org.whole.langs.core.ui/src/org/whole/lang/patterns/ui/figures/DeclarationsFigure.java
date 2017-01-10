/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EyeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.TableLayout;

/**
 *  @author  Riccardo Solmi
 */
public class DeclarationsFigure extends TableFigure {

    public DeclarationsFigure() {
        super(new TableLayout(4)
        		.withColumnSpacing(10).withRowSpacing(10).withColumnAlignment(3, Alignment.FILL)
        		.withMarginTop(5).withMarginBottom(5).withMarginLeft(3).withMarginRight(3));
        setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
        TableRowFigure headers = new TableRowFigure();
        Color color = ColorConstants.gray;
        EntityLabel label = new EntityLabel("Types");
        label.setForegroundColor(color);
        headers.add(label);
        label = new EntityLabel("Name");
        label.setForegroundColor(color);
        headers.add(label);
        headers.add(new EyeFigure());
        label = new EntityLabel("Definition");
        label.setForegroundColor(color);
        headers.add(label);
        add(headers, TableLayout.Placement.HEADER);
    }

    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        TableLayout l = getLayoutManager();
        if (l.rows() == 0)
            return;
        
		Rectangle b = getBounds();
		graphics.setBackgroundColor(FigureConstants.hostLanguageColor);
		graphics.fillRectangle(b.x, b.y, b.width, b.height);
        
        graphics.setBackgroundColor(ColorConstants.gray);
        drawHeadersRowBackground(graphics);
        graphics.setBackgroundColor(FigureConstants.modulesColor);
        int oldAlpha = graphics.getAlpha();
        graphics.setAlpha(getBackgroundAlpha());
        Rectangle tb = getTableBounds();
        Rectangle cb1 = l.getColumnBounds(1);
        graphics.fillRectangle(cb1.x, tb.y, cb1.width+l.getColumnBounds(2).width, tb.height);
        graphics.setAlpha(oldAlpha);
        graphics.setForegroundColor(ColorConstants.lightGray);
        drawRowSeparators(graphics);
        drawHeadersRowSeparator(graphics);
        drawTableBottomBorder(graphics);
    }
}
