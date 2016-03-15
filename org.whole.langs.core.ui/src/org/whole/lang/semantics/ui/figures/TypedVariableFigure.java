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

import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.SubSupLayout;

/**
 * @author Riccardo Solmi
 */
public class TypedVariableFigure extends AbstractVariableFigure {
	public TypedVariableFigure() {
		initContentPanes(4);
		setLayoutManager(new RowLayout());

		EntityFigure variableFigure = new EntityFigure(new SubSupLayout());
		variableFigure.add(createContentPane(0));
		variableFigure.add(createContentPane(1));
		variableFigure.add(createContentPane(2));
		add(variableFigure);
		addContentLight(":");
		add(createContentPane(3));
	}
}
