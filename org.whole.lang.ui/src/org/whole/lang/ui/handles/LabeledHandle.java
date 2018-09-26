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
package org.whole.lang.ui.handles;

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.whole.lang.ui.figures.EntityLabel;

/**
 * @author Enrico Persiani
 */
public class LabeledHandle extends AbstractHandle {
	public LabeledHandle(String label, GraphicalEditPart owner) {
		super(owner, new MoveHandleLocator(owner.getFigure()));
		setOpaque(false);
		EntityLabel figure = new EntityLabel(label);
		figure.setTextAlignment(PositionConstants.BOTTOM);
		figure.setBounds(owner.getFigure().getBounds().getCopy());
		figure.setBorder(new MarginBorder(5));
		add(figure);
	}

	protected DragTracker createDragTracker() {
		return null;
	}
}
