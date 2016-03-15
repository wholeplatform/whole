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
package org.whole.lang.grammars.ui.figures;

import org.whole.lang.ui.figures.ArrowFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.ArrowFactory.ArrowKind;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class BySizeFigure extends ContentPaneFigure {
	public BySizeFigure() {
		super(new RowLayout().withAutoresizeWeight(1f));
		initContentPanes(1);

	    add(new ArrowFigure(0.5f, ArrowKind.TRIANGLE, ArrowKind.NONE));
		add(createContentPane(0, LabelFactory.createContent()));
	    add(new ArrowFigure(0.5f, ArrowKind.NONE, ArrowKind.TRIANGLE));
	}
}