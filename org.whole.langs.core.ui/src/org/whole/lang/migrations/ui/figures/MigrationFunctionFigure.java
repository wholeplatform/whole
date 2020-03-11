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

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.figures.EntityFigure;

/**
 *  @generator Whole
 */
public class MigrationFunctionFigure extends ContentPaneFigure {

    public MigrationFunctionFigure() {
        initContentPanes(3);
        setLayoutManager(new ColumnLayout().withMarginTop(8).withMarginBottom(4));
        EntityFigure row = new EntityFigure(new RowLayout().withSpacing(16));
        row.add(createContentPane(0));
        row.add(createContentPane(1));
        add(row);
        add(createContentPane(2));
    }
}
