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
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IQualifiedFigure;
import org.whole.lang.ui.figures.OverQualifiedDataEntityFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class AssignableTypeTestFigure extends ContentPaneFigure implements IQualifiedFigure {
	private OverQualifiedDataEntityFigure entityTypeFigure;

	public AssignableTypeTestFigure(String operator) {
		super(new RowLayout().withSpacing(4));
		initContentPanes(1);

		addContentLight(operator);
		add(createNestedContentPanes(0, entityTypeFigure = new OverQualifiedDataEntityFigure()));
	}

	public void setQualifierName(String name) {
		entityTypeFigure.setQualifierName(name);
	}
	
	public EntityLabel getNameLabel() {
		return entityTypeFigure.getNameLabel();
	}
}
