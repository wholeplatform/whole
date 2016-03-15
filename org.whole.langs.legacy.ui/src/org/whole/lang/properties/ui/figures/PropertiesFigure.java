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
package org.whole.lang.properties.ui.figures;

import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class PropertiesFigure extends ContentPaneFigure {
	public PropertiesFigure() {
		super(new ColumnLayout().withMinorAlignment(Alignment.LEADING).withMarginLeft(4));
		initContentPanes(3);

		EntityFigure header = new EntityFigure(new RowLayout().withSpacing(8));
		header.addKeyword("properties");
		header.add(createContentPane(0));
		header.addKeyword("defaults");
		header.add(createContentPane(1));
		header.add(createFoldingToggle(2));

		add(header);
		add(createContentPane(2, new MarginBorder(0,24,0,0)));
	}
}
