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

import org.eclipse.draw2d.geometry.Insets;
import org.whole.lang.features.ui.layouts.IFeatureGroupLayout;
import org.whole.lang.ui.notations.map.borders.EmptyStyledBorder;
import org.whole.lang.ui.notations.map.borders.IStyledBorder;
import org.whole.lang.ui.notations.map.figures.StyledFigure;

/**
 * @author Riccardo Solmi
 */
public class FeatureGroupFigure extends StyledFigure {
	public FeatureGroupFigure(IFeatureGroupLayout layout, Insets insets) {
		super(layout);
		setShapeInsets(insets);
	}

	public void showDefaultLayout(boolean value) {
		((IFeatureGroupLayout) getLayoutManager()).useDefaultLayout(value);
		revalidate();
		repaint();
	}

	@Override
	protected void initFigure() {
		initContentPanes(2);

		add(shapeFigure = createContentPane(0));
		add(createContentPane(1));		
	}
	protected boolean hasVisibleConnections() {
		return true;
	}

	@Override
	protected IStyledBorder createShape() {
		return new EmptyStyledBorder();
	}
}
