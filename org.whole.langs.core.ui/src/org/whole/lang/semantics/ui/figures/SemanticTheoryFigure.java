/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.ui.figures.HeadersTableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class SemanticTheoryFigure extends ContentPaneFigure {
	public SemanticTheoryFigure() {
		initContentPanes(5);
		setLayoutManager(new ColumnLayout().withSpacing(10).withMargin(16, 16, 10, 16));

		IFigure headersFigure = new HeadersTableFigure();

		TableRowFigure uriRowFigure = new TableRowFigure();
		uriRowFigure.addContentLighter("URI");
		uriRowFigure.add(createContentPane(0));
		headersFigure.add(uriRowFigure);

		TableRowFigure namespaceRowFigure = new TableRowFigure();
		namespaceRowFigure.addContentLighter("Namespace");
		namespaceRowFigure.add(createContentPane(1));
		headersFigure.add(namespaceRowFigure);

		TableRowFigure nameRowFigure = new TableRowFigure();
		nameRowFigure.addContentLighter("Name");
		nameRowFigure.add(createContentPane(2));
		headersFigure.add(nameRowFigure);

		TableRowFigure versionRowFigure = new TableRowFigure();
		versionRowFigure.addContentLighter("Version");
		versionRowFigure.add(createContentPane(3));
		headersFigure.add(versionRowFigure);

		add(headersFigure);
		add(createContentPane(4));
	}
}
