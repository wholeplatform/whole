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
package org.whole.lang.json.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 *  @author  Riccardo Solmi
 */
public class ObjectFigure extends TableFigure {

    public ObjectFigure() {
        super(new TableLayout(2).withColumnSpacing(8).withRowSpacing(10).withMargin(5, 5, 5, 0));
        setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
    }

    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        TableLayout l = getLayoutManager();
        if (l.rows() == 0)
            return ;
        graphics.setBackgroundColor(ColorConstants.lightGray);
        int oldAlpha = graphics.getAlpha();
        graphics.setAlpha(getBackgroundAlpha());
        Rectangle tb = getTableBounds();
        Rectangle cb1 = l.getColumnBounds(0);
        graphics.fillRectangle(tb.x, tb.y, cb1.width + cb1.x-tb.x, tb.height);
        graphics.setAlpha(oldAlpha);

        graphics.setForegroundColor(ColorConstants.lightGray);
        drawRowSeparators(graphics);
    }
}
