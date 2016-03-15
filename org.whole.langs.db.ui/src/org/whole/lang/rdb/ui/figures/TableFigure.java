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
package org.whole.lang.rdb.ui.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 * @author Enrico Persiani
 */
public class TableFigure extends ContentPaneFigure {

    public TableFigure() {
		initContentPanes(7);
		setLayoutManager(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING)
				.withSpacing(5));

		setBorder(new CompoundBorder(new LineBorder(ColorConstants.lightGray, 2, Graphics.LINE_DASH), new MarginBorder(8)));
		
		EntityFigure headerRow = new EntityFigure(new RowLayout().withSpacing(10));
		headerRow.addContent("TABLE");
		headerRow.add(createContentPane(0));
		headerRow.addContentLighter("[");
		headerRow.add(createContentPane(1));
		headerRow.addContentLighter("]");
		headerRow.add(createContentPane(2));
		add(headerRow);

		add(createContentPane(3));
		add(createContentPane(4, new MarginBorder(16,0,0,0)));
		add(createContentPane(5));
		add(createContentPane(6));
    }
}
