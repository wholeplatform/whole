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
package org.whole.lang.ui.notations.map.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

/**
 * @author Riccardo Solmi
 */
public class DelegatingAnchor implements ConnectionAnchor, AncestorListener {
	private AbstractConnectionAnchor anchor;

	public void addAnchorListener(AnchorListener listener) {
		anchor.addAnchorListener(listener);
	}

	public Point getLocation(Point reference) {
		return anchor.getLocation(reference);
	}

	public IFigure getOwner() {
		return anchor.getOwner();
	}

	public Point getReferencePoint() {
		return anchor.getReferencePoint();
	}

	public void removeAnchorListener(AnchorListener listener) {
		anchor.removeAnchorListener(listener);
	}

	public void ancestorAdded(IFigure ancestor) {
		anchor.ancestorAdded(ancestor);
	}

	public void ancestorMoved(IFigure ancestor) {
		anchor.ancestorMoved(ancestor);
	}

	public void ancestorRemoved(IFigure ancestor) {
		anchor.ancestorRemoved(ancestor);
	}
}
