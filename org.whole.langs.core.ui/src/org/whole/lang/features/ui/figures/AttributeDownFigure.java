/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.features.ui.borders.AttributeDownStyledBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.map.borders.FillGradient;
import org.whole.lang.ui.notations.map.borders.IStyledBorder;
import org.whole.lang.ui.notations.map.figures.StyledFigure;
import org.whole.lang.ui.notations.map.layouts.LeafLayout;

/**
 * @author Riccardo Solmi
 */
public class AttributeDownFigure extends StyledFigure {

	public AttributeDownFigure() {
		super(new LeafLayout());
		setShapeInsets(new Insets(2,0,0,0));
		setShapeFillColor(ColorConstants.white);
		setShapeFillColor2(FigureConstants.brightBlueColor);
		setShapeFillGradient(FillGradient.VERTICAL);
	}

	@Override
	protected void initFigure() {
		initContentPanes(3);

		EntityFigure headerFigure = new EntityFigure(new RowLayout().withSpacing(8));
		headerFigure.add(createContentPane(0));
//		headerFigure.addParenthesis(" (");
		headerFigure.add(createContentPane(1));
//		headerFigure.addParenthesis(")");

		EntityFigure shapeFigure0 = new EntityFigure(new UnderColumnLayout().withSpacing(4).withMarginLeft(12).withMinorAlignment(Alignment.CENTER));
		shapeFigure0.add(headerFigure);
		shapeFigure0.add(createContentPane(2));

		add(shapeFigure = shapeFigure0);
	}

	protected boolean hasVisibleConnections() {
		return false;
	}

	@Override
	protected IStyledBorder createShape() {
		return new AttributeDownStyledBorder();
	}
}
