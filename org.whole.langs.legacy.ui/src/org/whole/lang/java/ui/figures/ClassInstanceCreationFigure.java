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
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 *  @author Riccardo Solmi, Enrico Persiani
 */
public class ClassInstanceCreationFigure extends ContentPaneFigure {
	private IFigure f1, f2, f3;

    public ClassInstanceCreationFigure() {
        super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
        initContentPanes(5);
        EntityFigure row;
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        row.addKeyword("new");
        row.add(createContentPane(0));
        row.add(createContentPane(1));
        row.add(createContentPane(2));
        row.addContentLight("(");
        row.add(createContentPane(3));
        row.addContentLight(")");
        f1 = row.addContentLighter("{");
        add(f2 = new EntityFigure(new RowLayout().withSpacing(4)));
        f2.add(new EntityLabel("    "));
        f2.add(createContentPane(4));
        f3 = addContentLighter("}");
    }

	public void hideAnonymousClassDeclaration(boolean value) {
		f1.setVisible(!value);
		f2.setVisible(!value);
		f3.setVisible(!value);
	}
}
