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
package org.whole.lang.queries.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IQualifiedFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.SquareBracketsBorder;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class VariableTestFigure extends ContentPaneFigure implements IQualifiedFigure{
	private EntityLabel environmentLabel;

	public VariableTestFigure(boolean showBrackets) {
		super(new RowLayout().withSpacing(4).withMarginLeft(showBrackets ? 0 : 5));
		initContentPanes(1);

		addKeyword("as");

		EntityFigure variableFigure = new EntityFigure(new OverLayout());
		variableFigure.add(createContentPane(0, LabelFactory.createIdentifier()));
		variableFigure.add(environmentLabel = LabelFactory.createModule());
		add(variableFigure);

		environmentLabel.setVisible(false);

		if (showBrackets)
			setBorder(new SquareBracketsBorder(8, 8));
	}

	public void setQualifierName(String name) {
		if (name != null) {
			environmentLabel.setVisible(true);
			environmentLabel.setText(name);
		} else
			environmentLabel.setVisible(false);
	}
	public EntityLabel getNameLabel() {
		return (EntityLabel) getContentPane(0);
	}
}
