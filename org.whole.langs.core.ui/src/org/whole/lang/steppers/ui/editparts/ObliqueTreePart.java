/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.steppers.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.steppers.ui.figures.ObliqueTreeFigure;

/**
 *  @generator Whole
 */
public class ObliqueTreePart extends AbstractCompositePart {
	private boolean dashedStyle;

	public ObliqueTreePart(boolean inArgumentsFlow) {
		this(inArgumentsFlow, false);
	}
	public ObliqueTreePart(boolean inArgumentsFlow, boolean dashedStyle) {
		setFlag(FLAG_REVERSED, inArgumentsFlow);
		this.dashedStyle = dashedStyle;
	}

	protected IFigure createFigure() {
        return new ObliqueTreeFigure(isReversed(), dashedStyle);
    }
}
