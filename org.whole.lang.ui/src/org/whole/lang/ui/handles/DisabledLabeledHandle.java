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
package org.whole.lang.ui.handles;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;

/**
 * @author Enrico Persiani
 */
public class DisabledLabeledHandle extends EntityFigure {
	public DisabledLabeledHandle(String label, GraphicalEditPart owner) {
		setOpaque(false);
		setToolTip(new EntityLabel(label));
		setBounds(((Viewport) owner.getFigure()).getContents().getBounds());
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		graphics.setAlpha(50);
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.fillRectangle(getBounds());
	}

	protected DragTracker createDragTracker() {
		return null;
	}
}
