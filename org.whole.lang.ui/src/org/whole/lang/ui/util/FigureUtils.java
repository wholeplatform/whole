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
package org.whole.lang.ui.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/** 
 * @author Enrico Persiani
 */
public class FigureUtils {
	public static int getPositionOf(IFigure figure, IFigure relativeTo) {
		return getApproximatePositionOf(figure, relativeTo, 0.0);
	}
	public static int getApproximatePositionOf(IFigure figure, IFigure relativeTo, double approx) {
		Rectangle bounds = figure.getBounds();
		Rectangle relativeToBounds = relativeTo.getBounds();
		
		int hApprox = (int) Math.round(bounds.width * approx);
		int vApprox = (int) Math.round(bounds.height * approx);

		if (bounds.x + hApprox > relativeToBounds.right())
			return PositionConstants.EAST;
		else if (bounds.right() - hApprox < relativeToBounds.x)
			return PositionConstants.WEST;
		else if (bounds.y + vApprox > relativeToBounds.bottom())
			return PositionConstants.SOUTH;
		else if (bounds.bottom() - vApprox < relativeToBounds.y)
			return PositionConstants.NORTH;
		else
			return PositionConstants.NONE;
	}

	public static LinkedList<IGraphicalEntityPart> filterClosestVertically(List<IGraphicalEntityPart> entityParts, boolean aboveLimit, int verticalLimit) {
		int targetLimit = verticalLimit * (aboveLimit ? 1 : -1);
		int closestY = aboveLimit ? 0 : -Integer.MAX_VALUE;
		LinkedList<IGraphicalEntityPart> containers = new LinkedList<>();
		LinkedList<IGraphicalEntityPart> closestVertically = new LinkedList<>();

		for (IGraphicalEntityPart entityPart : entityParts) {
			Rectangle bounds = entityPart.getFigure().getBounds();
			if (bounds.y < verticalLimit && verticalLimit < bounds.bottom() && //TODO check for minimum figure height
					!entityPart.getChildren().isEmpty())
				containers.add(entityPart);
			else {
				int limit = aboveLimit ? bounds.bottom() : bounds.y;
				if (limit >= closestY && limit < targetLimit) {
					if (limit > closestY)
						closestVertically.clear();
					closestVertically.add(entityPart);
					closestY = limit;
				}
			}
		}
		closestVertically.addAll(containers);
		return closestVertically;
	}
	public static LinkedList<IGraphicalEntityPart> filterClosestHorizontally(List<IGraphicalEntityPart> entityParts, boolean beforeLimit, int horizontalLimit) {
		int targetLimit = horizontalLimit * (beforeLimit ? 1 : -1);
		int closestX = beforeLimit ? 0 : -Integer.MAX_VALUE;
		LinkedList<IGraphicalEntityPart> containers = new LinkedList<>();
		LinkedList<IGraphicalEntityPart> closestHorizontally = new LinkedList<>();

		for (IGraphicalEntityPart entityPart : entityParts) {
			Rectangle bounds = entityPart.getFigure().getBounds();
			if (bounds.x < horizontalLimit && horizontalLimit < bounds.right() && //TODO check for minimum figure height
					!entityPart.getChildren().isEmpty())
				containers.add(entityPart);
			else {
				int limit = beforeLimit ? bounds.right() : bounds.x;
				if (limit >= closestX && limit < targetLimit) {
					if (limit > closestX)
						closestHorizontally.clear();
					closestHorizontally.add(entityPart);
					closestX = limit;
				}
			}
		}
		return closestHorizontally;
	}
	public static IGraphicalEntityPart getClosestWrappingVertically(List<IGraphicalEntityPart> entityParts, int verticalLimit) {
		IGraphicalEntityPart lastEntityPart = null;
		for (Iterator<IGraphicalEntityPart> iterator = entityParts.iterator(); iterator.hasNext();) {
			IGraphicalEntityPart entityPart = (IGraphicalEntityPart) iterator.next();
			Rectangle bounds = entityPart.getFigure().getBounds();
			if (bounds.y >= verticalLimit)
				break;
			lastEntityPart = entityPart;
		}
		return lastEntityPart != null ? lastEntityPart : entityParts.iterator().next();
	}
	public static IGraphicalEntityPart getClosestWrappingHorizontally(List<IGraphicalEntityPart> entityParts, int horizontalLimit) {
		IGraphicalEntityPart lastEntityPart = null;
		for (Iterator<IGraphicalEntityPart> iterator = entityParts.iterator(); iterator.hasNext();) {
			IGraphicalEntityPart entityPart = (IGraphicalEntityPart) iterator.next();
			Rectangle bounds = entityPart.getFigure().getBounds();
			if (bounds.x >= horizontalLimit)
				break;
			lastEntityPart = entityPart;
		}
		return lastEntityPart != null ? lastEntityPart : entityParts.iterator().next();
	}

	public static IGraphicalEntityPart getClosestAbove(IEntityPartViewer viewer, IGraphicalEntityPart entityPart) {
		return getClosestAbove(viewer, entityPart.getFigure());
	}
	public static IGraphicalEntityPart getClosestAbove(IEntityPartViewer viewer, IFigure figure) {
		return getClosestAbove(viewer, figure.getBounds());
	}
	@SuppressWarnings("unchecked")
	public static IGraphicalEntityPart getClosestAbove(IEntityPartViewer viewer, Rectangle bounds) {
		return getClosestAbove((viewer.getContents().getChildren()), bounds);
	}
	@SuppressWarnings("unchecked")
	public static IGraphicalEntityPart getClosestAbove(List<IGraphicalEntityPart> entityParts, Rectangle bounds) {
		if (entityParts.isEmpty())
			throw new IllegalArgumentException("empty list");

		LinkedList<IGraphicalEntityPart> closestAbove = new LinkedList<>();
		for (IGraphicalEntityPart entityPart : filterClosestVertically(entityParts, true, bounds.y))
			closestAbove.add(entityPart.getChildren().isEmpty() ? entityPart : getClosestAbove(entityPart.getChildren(), bounds));

		closestAbove = filterClosestVertically(closestAbove, true, bounds.y);

		return closestAbove.size() == 1 ? closestAbove.getFirst() : 
			getClosestWrappingHorizontally(closestAbove, bounds.x);
	}

	public static IGraphicalEntityPart getClosestBelow(IEntityPartViewer viewer, IGraphicalEntityPart entityPart) {
		return getClosestBelow(viewer, entityPart.getFigure());
	}
	public static IGraphicalEntityPart getClosestBelow(IEntityPartViewer viewer, IFigure figure) {
		return getClosestBelow(viewer, figure.getBounds());
	}
	@SuppressWarnings("unchecked")
	public static IGraphicalEntityPart getClosestBelow(IEntityPartViewer viewer, Rectangle bounds) {
		return getClosestBelow(viewer.getRootEditPart().getChildren(), bounds);
	}
	public static IGraphicalEntityPart getClosestBelow(List<IGraphicalEntityPart> entityParts, Rectangle bounds) {
		throw new UnsupportedOperationException();
	}

	public static IGraphicalEntityPart getClosest(int inDirection, IEntityPartViewer viewer, IGraphicalEntityPart entityPart) {
		return getClosest(inDirection, viewer, entityPart.getFigure());
	}
	public static IGraphicalEntityPart getClosest(int inDirection, IEntityPartViewer viewer, IFigure figure) {
		return getClosest(inDirection, viewer, figure.getBounds());
	}
	@SuppressWarnings("unchecked")
	public static IGraphicalEntityPart getClosest(int inDirection, IEntityPartViewer viewer, Rectangle bounds) {
		return getClosest(inDirection, viewer.getRootEditPart().getChildren(), bounds);
	}
	public static IGraphicalEntityPart getClosest(int inDirection, List<IGraphicalEntityPart> entityParts, Rectangle bounds) {
		throw new UnsupportedOperationException();
	}
}
