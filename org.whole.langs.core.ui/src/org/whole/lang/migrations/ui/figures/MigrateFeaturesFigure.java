/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.migrations.ui.figures;

import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;

/**
 *  @generator Whole
 */
public class MigrateFeaturesFigure extends TableFigure {

    public MigrateFeaturesFigure() {
        setLayoutManager(new TableLayout().withRowSpacing(10).withColumnSpacing(10).withMarginTop(5).withMarginLeft(5).withMarginBottom(5));
        EntityFigure tableRow = new EntityFigure(new TableRowLayout());
        tableRow.addContentLighter("Source");
        tableRow.addContentLighter("Target");
        add(tableRow, TableLayout.Placement.HEADER);
    }

    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        TableLayout l = getLayoutManager();
        if (l.rows() == 0)
            return ;
        graphics.setBackgroundColor(ColorConstants.gray);
        drawHeadersRowBackground(graphics);
        graphics.setBackgroundColor(ColorConstants.lightGray);
        graphics.setForegroundColor(ColorConstants.lightGray);
        drawHeadersRowSeparator(graphics);
        drawRowSeparators(graphics);
        drawColumnSeparators(graphics);
    }
}
