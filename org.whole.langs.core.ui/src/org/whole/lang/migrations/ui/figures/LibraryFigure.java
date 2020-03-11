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
import org.whole.lang.ui.figures.HeadersTableFigure;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.figures.EntityFigure;

/**
 *  @generator Whole
 */
public class LibraryFigure extends ContentPaneFigure {

    public LibraryFigure() {
        initContentPanes(4);
        setLayoutManager(new ColumnLayout().withMargin(16, 16, 10, 16).withSpacing(10));
        HeadersTableFigure headersTable = new HeadersTableFigure();
        EntityFigure tableRow = new EntityFigure(new TableRowLayout());
        tableRow.addContentLighter("uri");
        tableRow.add(createContentPane(0));
        headersTable.add(tableRow);
        EntityFigure tableRow1 = new EntityFigure(new TableRowLayout());
        tableRow1.addContentLighter("Namespace");
        tableRow1.add(createContentPane(1));
        headersTable.add(tableRow1);
        EntityFigure tableRow2 = new EntityFigure(new TableRowLayout());
        tableRow2.addContentLighter("Name");
        tableRow2.add(createContentPane(2));
        headersTable.add(tableRow2);
        add(headersTable);
        add(createContentPane(3));
    }
}
