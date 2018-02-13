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
package org.whole.examples.lang.imp.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class DoWhileStatementFigure extends ContentPaneFigure {
    private IFigure p1, p2;

    public DoWhileStatementFigure() {
        super(new ColumnLayout());
        initContentPanes(2);
        EntityFigure row;
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        row.addKeyword("do");
        p1 = row.addLiteral("{");
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        row.add(new EntityLabel("    "));
        row.add(createContentPane(0));
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        p2 = row.addLiteral("}");
        row.addKeyword("while");
        row.addLiteral("(");
        row.add(createContentPane(1));
        row.addLiteral(")");
        showBraces(false);
    }

    public void showBraces(boolean val) {
        p1.setVisible(val);
        p2.setVisible(val);
    }
}
