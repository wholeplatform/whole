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
package org.whole.lang.xml.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.ui.notations.outline.figures.OutlineCompositeNodeFigure;

/**
 * @generator Enrico Persiani
 */
public class CDataSectOutlineFigure extends OutlineCompositeNodeFigure {
	public CDataSectOutlineFigure() {
		setLayoutManager(new RowLayout().withMarginTop(5).withMinorAlignment(Alignment.LEADING).withSpacing(4));
		initContentPanes(1);

		add(createFoldingToggle(0));
		addLabel(NotationImages.XML_CDATASECT16);
		CompositeFigure composite = new CompositeFigure(false);
		composite.getLayoutManager().withMarginTop(0);
		add(createContentPane(0, composite));
	}
	@Override
	protected void paintConnections(Graphics graphics) {
	}
}
