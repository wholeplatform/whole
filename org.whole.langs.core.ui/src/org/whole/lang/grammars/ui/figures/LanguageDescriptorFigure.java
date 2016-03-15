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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;

/**
 * @author Riccardo Solmi
 */
public class LanguageDescriptorFigure extends TableFigure {
	public LanguageDescriptorFigure() {
		super(2);
		initContentPanes(4);

		TableRowFigure uriRowFigure = new TableRowFigure();
		uriRowFigure.addContentLighter("URI");
		uriRowFigure.add(createContentPane(0));
		add(uriRowFigure);
		
		TableRowFigure namespaceRowFigure = new TableRowFigure();
		namespaceRowFigure.addContentLighter("Namespace");
		namespaceRowFigure.add(createContentPane(1));
		add(namespaceRowFigure);

		TableRowFigure grammarRowFigure = new TableRowFigure();
		grammarRowFigure.addContentLighter("Name");
		grammarRowFigure.add(createContentPane(2));
		add(grammarRowFigure);

		TableRowFigure versionRowFigure = new TableRowFigure();
		versionRowFigure.addContentLighter("Version");
		versionRowFigure.add(createContentPane(3));
		add(versionRowFigure);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setForegroundColor(ColorConstants.lightGray);
		drawTableRowsBorder(g);
	}
}
