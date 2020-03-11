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
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.figures.AngleBracketsBorder;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.figures.CurlyBracketsBorder;

/**
 *  @generator Whole
 */
public class InitializerDeclFigure extends ContentPaneFigure {

    public InitializerDeclFigure() {
        initContentPanes(8);
        setLayoutManager(new RowLayout().withSpacing(4));
        add(createContentPane(0));
        add(createContentPane(1));
        addKeyword("init");
        add(createContentPane(2));
        add(createContentPane(3, new AngleBracketsBorder()));
        add(createContentPane(4, new RoundBracketsBorder()));
        add(createContentPane(5));
        addKeyword("where");
        add(createContentPane(6));
        add(createContentPane(7, new CurlyBracketsBorder()));
    }
}
