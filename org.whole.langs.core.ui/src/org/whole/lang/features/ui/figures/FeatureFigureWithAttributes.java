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
package org.whole.lang.features.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.features.ui.layouts.FeatureTreeDownLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderLeftLayout;
import org.whole.lang.ui.notations.map.borders.IStyledBorder;
import org.whole.lang.ui.notations.map.borders.RectangleStyledBorder;
import org.whole.lang.ui.notations.map.figures.StyledFigure;
import org.whole.lang.ui.notations.map.layouts.IStyledLayout;

/**
 * @author Riccardo Solmi
 */
public class FeatureFigureWithAttributes extends StyledFigure {
	public FeatureFigureWithAttributes() {
		this(new FeatureTreeDownLayout());
	}
	public FeatureFigureWithAttributes(IStyledLayout layout) {
		super(layout);
		setShapeInsets(new Insets(1,0,0,3));
	}

	@Override
	protected void initFigure() {
		initContentPanes(3);

		EntityFigure headerFigure = new EntityFigure(new RowLayout().withSpacing(4).withMarginLeft(12));
		headerFigure.add(createContentPane(0));
		headerFigure.add(createFoldingToggle(2));

		shapeFigure = new EntityFigure(new UnderLeftLayout().withSpacing(2));
		shapeFigure.add(headerFigure);
		shapeFigure.add(createContentPane(1));
		
		add(shapeFigure);
		add(createContentPane(2));		
	}

	@Override
	protected IStyledBorder createShape() {
		return new RectangleStyledBorder();
	}

	public void showAttributes(boolean visible) {
		getContentPane(1).setVisible(visible);
	}

	protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        
       	IFigure cp1 = getContentPane(1);
       	if (cp1.isVisible()) {
			Rectangle cr = cp1.getBounds();
	        Rectangle r = getShapeFigure().getBounds();
	
	       	g.setForegroundColor(getShape().getLineColor());
	       	g.drawLine(r.x, cr.y-1, r.right()-1, cr.y-1);
       	}
	}
}
