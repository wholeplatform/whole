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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.map.borders.FillGradient;
import org.whole.lang.ui.notations.map.borders.IStyledBorder;
import org.whole.lang.ui.notations.map.borders.RectangleStyledBorder;
import org.whole.lang.ui.notations.map.figures.StyledFigure;
import org.whole.lang.ui.notations.map.layouts.IStyledLayout;

/**
 * @author Riccardo Solmi
 */
public class FeatureFigure extends StyledFigure {
	public FeatureFigure(IStyledLayout layout) {
		super(layout);
		setShapeInsets(new Insets(1,0,0,3));
		setShapeFillColor(ColorConstants.white);
		setShapeFillColor2(FigureConstants.brightBlueColor);
		setShapeFillGradient(FillGradient.VERTICAL);
	}

	@Override
	protected void initFigure() {
		initContentPanes(2);

		shapeFigure = new EntityFigure(new RowLayout().withSpacing(4).withMarginLeft(12));
		shapeFigure.add(createContentPane(0));
		shapeFigure.add(createFoldingToggle(1));
		
		add(shapeFigure);
//TODO add view tracking support (FIXME connections painting)
//		EntityFigure trackingFigure = new EntityFigure(new MonoLayout().withMajorAlignment(Alignment.CENTER).withAutoresizeWeight(1f)).withViewportTracking(ViewportTracking.VERTICAL);
//		trackingFigure.add(shapeFigure);
//		add(trackingFigure);

		add(createContentPane(1));		
	}

	@Override
	protected IStyledBorder createShape() {
		return new RectangleStyledBorder();
	}
}
