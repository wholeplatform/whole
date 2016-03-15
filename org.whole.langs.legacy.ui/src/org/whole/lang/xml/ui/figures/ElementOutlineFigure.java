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

import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.ui.notations.outline.figures.OutlineCompositeNodeFigure;

/**
 * @author Riccardo Solmi
 */
public class ElementOutlineFigure extends OutlineCompositeNodeFigure {
	public ElementOutlineFigure(boolean startOpened) {
		setLayoutManager(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
		initContentPanes(3);

		EntityFigure topFigure = new EntityFigure(new RowLayout().withSpacing(4));
		topFigure.add(createFoldingToggle(2));
		topFigure.addLabel(NotationImages.XML_TAG16);
		topFigure.add(createContentPane(0));
		topFigure.add(createContentPane(1));

		add(topFigure);
		add(createContentPane(2, new MarginBorder(0,16,0,0)));

		if (!startOpened)
	    	clickFoldingToggle(0);
	}
}
