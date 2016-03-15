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
package org.whole.lang.java.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 *  @author Enrico Persiani
 */
public class LambdaExpressionFigure extends ContentPaneFigure {
	private IFigure f1, f2, f3, f4;

    public LambdaExpressionFigure() {
        super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
        initContentPanes(2);
        EntityFigure row;
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        f1 = row.addContentLight("(");
        row.add(createContentPane(0));
        f2 = row.addContentLight(")");
        row.addContentLight("->");
        f3 = row.addContentLighter("{");
        add(createContentPane(1, new MarginBorder(0,16,0,0)));
        f4 = addContentLighter("}");
    }

	public void hideParentheses(boolean value) {
		f1.setVisible(!value);
		f2.setVisible(!value);
	}

	public void hideBraces(boolean value) {
		f3.setVisible(!value);
		f4.setVisible(!value);
	}
}
