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
package org.whole.lang.ui.notations.flowchart.figures;

import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.FoldedPageBorder;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class CodeFigure extends NodeFigure {
	public CodeFigure() {
		initContentPanes(2);

		setLayoutManager(new ColumnLayout().withMinorAlignment(Alignment.CENTER).withSpacing(4));

		add(createContentPane(0));
		add(createContentPane(1));
		setBorder(new CompoundBorder(
				new FoldedPageBorder(),
	            new MarginBorder(0,4,4,4)));
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopOrBottomMiddleAnchor(this)};
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension d = super.getPreferredSize(wHint, hHint);
		d.width = Math.max(d.width, 40);
		d.height = Math.max(d.height, 55);
		return d;
	}
}
