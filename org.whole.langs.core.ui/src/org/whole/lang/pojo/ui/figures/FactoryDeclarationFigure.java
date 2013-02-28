/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.pojo.ui.figures;

import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.figures.EntityLabel;

/**
 *  @author Riccardo Solmi
 */
public class FactoryDeclarationFigure extends ContentPaneFigure {

    public FactoryDeclarationFigure() {
        super(new ColumnLayout());
        initContentPanes(3);
        EntityFigure row;
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        setBorder(new MarginBorder(4, 0, 4, 0));
        row.addKeyword("factory");
        row.add(createContentPane(0));
        row.addKeyword("prefix");
        row.add(createContentPane(1));
        row.add(createToggleFigure(2));
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        row.add(new EntityLabel("    "));
        row.add(createContentPane(2));
    }
}
