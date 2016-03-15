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
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class ClassDeclarationFigure extends ContentPaneFigure {
	private IFigure f1, f2, f3, f4;

	public ClassDeclarationFigure() {
		super(new ColumnLayout());
		initContentPanes(7);
		EntityFigure row;
		add(createContentPane(0));
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(createFoldingToggle(6));
		row.add(createContentPane(1));
		row.addKeyword("class");
		row.add(createContentPane(2));
		f1 = row.addContentLight("<");
		row.add(createContentPane(3));
		f2 = row.addContentLight(">");
		f3 = row.addKeyword("extends");
		row.add(createContentPane(4));
		f4 = row.addKeyword("implements");
		row.add(createContentPane(5));
		row.addContentLighter("{");
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(new EntityLabel("    "));
		row.add(createContentPane(6));
		addContentLighter("}");
	}

	public void hideTypeParameters(boolean value) {
		f1.setVisible(!value);
		f2.setVisible(!value);
	}

	public void hideSuperclassType(boolean value) {
		f3.setVisible(!value);
	}

	public void hideSuperInterfaceTypes(boolean value) {
		f4.setVisible(!value);
	}
}
