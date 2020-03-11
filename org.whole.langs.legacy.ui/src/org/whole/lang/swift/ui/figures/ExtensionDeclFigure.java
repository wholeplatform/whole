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
package org.whole.lang.swift.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.figures.CurlyBracketsBorder;

/**
 *  @generator Whole
 */
public class ExtensionDeclFigure extends ContentPaneFigure {

    public ExtensionDeclFigure() {
        initContentPanes(6);
        setLayoutManager(new ColumnLayout().withSpacing(4));
        EntityFigure row = new EntityFigure(new RowLayout().withSpacing(4));
        row.add(createContentPane(0));
        row.add(createContentPane(1));
        row.addKeyword("extension");
        row.add(createContentPane(2));
        row.addKeyword(":");
        row.add(createContentPane(3));
        row.addKeyword("where");
        row.add(createContentPane(4));
        add(row);
        EntityFigure row1 = new EntityFigure(new MonoLayout());
        row1.add(createContentPane(5, new CurlyBracketsBorder()));
        add(row1);
    }
}
