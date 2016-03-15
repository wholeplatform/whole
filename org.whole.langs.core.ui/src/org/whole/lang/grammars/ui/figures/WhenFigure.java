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
import org.whole.lang.ui.figures.AngleBracketsBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class WhenFigure extends ContentPaneFigure {
	public WhenFigure() {
		super(new OverLayout());
		initContentPanes(2);
		
		EntityFigure row = new EntityFigure(new RowLayout());
		row.addKeyword("when ");
		row.add(createContentPane(0));

		add(createContentPane(1));
		add(row);
		
		setBorder(new AngleBracketsBorder(true, true) {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(ColorConstants.lightGray);
			}
		});
	}
}
