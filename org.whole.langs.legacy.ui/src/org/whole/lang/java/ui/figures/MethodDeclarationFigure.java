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
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class MethodDeclarationFigure extends ContentPaneFigure {
	private EntityFigure typeParameters;
	private EntityFigure thrownExceptions;
	private EntityFigure bodyDeclaration;
	private IFigure curlyOpen;
	private IFigure semicolon;
	private boolean hasBodyDeclaration = true;

	public MethodDeclarationFigure() {
		super(new ColumnLayout());
		initContentPanes(8);

		add(createContentPane(7));
		EntityFigure row = new EntityFigure(new RowLayout().withSpacing(4));
		row.add(createFoldingToggle(6));
		row.add(createContentPane(0));
		
		typeParameters = new EntityFigure(new RowLayout().withSpacing(4));
		typeParameters.addContentLight("<");
		typeParameters.add(createContentPane(1));
		typeParameters.addContentLight(">");
		
		row.add(typeParameters);
		row.add(createContentPane(2));
		row.add(createContentPane(3));
		row.addContentLight("(");
		row.add(createContentPane(4));
		row.addContentLight(")");

		thrownExceptions = new EntityFigure(new RowLayout().withSpacing(4));
		thrownExceptions.addKeyword("throws");
		thrownExceptions.add(createContentPane(5));

		row.add(thrownExceptions);
		curlyOpen = row.addContentLighter("{");
		semicolon = row.addContentLighter(";");
		add(row);

		bodyDeclaration = new EntityFigure(new ColumnLayout());
		bodyDeclaration.add(createContentPane(6, new MarginBorder(0,16,0,0)));
		bodyDeclaration.addContentLighter("}");
		add(bodyDeclaration);
		showBodyDeclaration(true);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 6)
			bodyDeclaration.setVisible(hasBodyDeclaration && !getFoldingToggle(0).getModel().isSelected());
		else
			super.toggleVisibility(paneIndex);
	}

	public void showTypeParameters(boolean visible) {
		typeParameters.setVisible(visible);
	}

	public void showThrownExceptions(boolean visible) {
		thrownExceptions.setVisible(visible);
	}

	public void showBodyDeclaration(boolean visible) {
		hasBodyDeclaration = visible;
		curlyOpen.setVisible(hasBodyDeclaration);
		semicolon.setVisible(!hasBodyDeclaration);
		bodyDeclaration.setVisible(hasBodyDeclaration && !getFoldingToggle(0).getModel().isSelected());
	}
}
