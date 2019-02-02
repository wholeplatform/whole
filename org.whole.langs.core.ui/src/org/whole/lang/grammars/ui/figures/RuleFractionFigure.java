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
package org.whole.lang.grammars.ui.figures;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.FractionFigure;
import org.whole.lang.ui.layout.FractionLayout;

/**
 * @author Riccardo Solmi
 */
public class RuleFractionFigure extends FractionFigure {
	public RuleFractionFigure() {
		super();
	}
	public RuleFractionFigure(FractionLayout layout) {
		super(layout);
	}

	public float getMajorAutoresizeWeight() {
		return 1f;
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}

	@SuppressWarnings("unchecked")
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
//		List<IFigure> children = (List<IFigure>) getChildren();
//        Rectangle fb = children.get(2).getBounds();
//        g.drawLine(fb.getLeft(), fb.getRight());
	}
}