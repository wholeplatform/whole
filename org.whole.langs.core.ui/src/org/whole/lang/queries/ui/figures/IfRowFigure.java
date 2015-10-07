/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.ui.figures;

import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.ViewportTrackingEntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class IfRowFigure extends ContentPaneFigure {
	public IfRowFigure() {
		super(new TableRowLayout() {
			@Override
			protected void setLocation(Rectangle area, int[] x, int[] y) {
				super.setLocation(area, x, y);
				y[0] = area.y;
				childSize[0].width = getColumnWidth(0);
				childSize[0].height = figAscent+figDescent; 
			}
		});
		initContentPanes(2);
		
		EntityFigure type = new ViewportTrackingEntityFigure(new MonoLayout()
				.withMinorAlignment(Alignment.LEADING)
				.withMajorAlignment(Alignment.CENTER));
		type.add(createContentPane(0));
		add(type);

		add(createContentPane(1));
	}
}
