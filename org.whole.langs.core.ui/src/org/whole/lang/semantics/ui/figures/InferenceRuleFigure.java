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
package org.whole.lang.semantics.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityRectangleFigure;
import org.whole.lang.ui.layout.FractionLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class InferenceRuleFigure extends ContentPaneFigure {
	protected EntityFigure whenClauseFigure;
	protected IFigure fractionFigure;

	public InferenceRuleFigure() {
		super(new TableRowLayout());
		initContentPanes(4);

		add(createContentPane(0));
		
		EntityFigure ruleFigure = new EntityFigure(new RowLayout());

		EntityFigure inferenceFigure = new EntityFigure(new FractionLayout().withSpacing(2));
		inferenceFigure.add(createContentPane(1));
		inferenceFigure.add(createContentPane(2));		
		inferenceFigure.add(fractionFigure = new EntityRectangleFigure());
		ruleFigure.add(inferenceFigure);

		whenClauseFigure = new EntityFigure(new RowLayout().withMarginLeft(16).withSpacing(8));
		whenClauseFigure.addKeyword("if");
		whenClauseFigure.add(createContentPane(3));
		ruleFigure.add(whenClauseFigure);

		add(ruleFigure);
	}

	public void showAsInference(boolean value) {
		getContentPane(1).setVisible(value);
		fractionFigure.setVisible(value);
	}

	public void showWhenClause(boolean value) {
		whenClauseFigure.setVisible(value);
	}
}
