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
package org.whole.lang.queries.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.RoundBracketsBorder;

/**
 * @author Riccardo Solmi
 */
public class OrPart extends CompositeColumnWithPlaceholderPart {
	private Border border;

    protected IFigure createFigure() {
    	border = new RoundBracketsBorder() {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(FigureConstants.contentLighterColor);
			}
		};
    	return new CompositeFigure(false) {
    		protected void paintFigure(Graphics g) {
    			super.paintFigure(g);

    			g.setForegroundColor(ColorConstants.lightGray);

    			g.setLineStyle(SWT.LINE_CUSTOM);
    			g.setLineDash(new int[] {1,1});
    			drawFixedSizeRowSeparators(g);
    			g.setLineStyle(SWT.LINE_SOLID);
    			g.setLineDash((int[]) null);
    		}
    	};
    }

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		boolean hasBorder = getFigure().getBorder() != CompositePlaceHolderBorder.OPTIONAL_VERTICAL;
		boolean showBorder = Matcher.matchAny(getParentModelEntity(),
//				QueriesEntityDescriptorEnum.Not,
//				QueriesEntityDescriptorEnum.And,
				QueriesEntityDescriptorEnum.Or);
		if (showBorder && !hasBorder)
			getFigure().setBorder(border);
		else if (hasBorder && !showBorder)
			getFigure().setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
	}
}
