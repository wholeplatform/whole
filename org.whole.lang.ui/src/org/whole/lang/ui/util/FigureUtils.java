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

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

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

	@SuppressWarnings("unchecked")
	public static LinkedList<IGraphicalEntityPart> extractContainerEntityParts(LinkedList<IGraphicalEntityPart> entityParts) {
		ListIterator<IGraphicalEntityPart> iterator = entityParts.listIterator();
		// replace containers
		while (iterator.hasNext()) {
			IGraphicalEntityPart entityPart = iterator.next();
			if (!entityPart.getChildren().isEmpty()) {
				iterator.remove();
				LinkedList<IGraphicalEntityPart> children = new LinkedList<IGraphicalEntityPart>(entityPart.getChildren());
				for (IGraphicalEntityPart descendantPart : extractContainerEntityParts(children))
					iterator.add(descendantPart);
			}
		}
		return entityParts;
	}
	@SuppressWarnings("unchecked")
	public static LinkedList<IGraphicalEntityPart> filterClosestVertically(List<IGraphicalEntityPart> entityParts, boolean above, Rectangle bounds) {
		int targetLimit = above ? bounds.y : bounds.bottom();
		int closestY = above ? 0 : Integer.MAX_VALUE;
		LinkedList<IGraphicalEntityPart> closestVertically = new LinkedList<>();

		for (IGraphicalEntityPart entityPart : entityParts) {
			if (!entityPart.getFigure().isVisible())
				continue;
			Rectangle partBounds = entityPart.getFigure().getBounds();
			if (partBounds.contains(bounds) && !entityPart.getChildren().isEmpty()) {
				LinkedList<IGraphicalEntityPart> filtered = filterClosestVertically(entityPart.getChildren(), above, bounds);
				if (!filtered.isEmpty())
					return filtered;
			} else {
				int limit = above ? partBounds.bottom() : partBounds.y;
				if ((above && limit >= closestY && limit < targetLimit) ||
						(!above && limit <= closestY && limit > targetLimit)) {
					if (limit > closestY)
						closestVertically.clear();
					closestVertically.add(entityPart);
					closestY = limit;
				}
			}
		}
		return extractContainerEntityParts(closestVertically);
	}
	@SuppressWarnings("unchecked")
	public static LinkedList<IGraphicalEntityPart> filterClosestHorizontally(List<IGraphicalEntityPart> entityParts, boolean before, Rectangle bounds) {
		int targetLimit = bounds.x * (before ? 1 : -1);
		int closestX = before ? 0 : -Integer.MAX_VALUE;
		LinkedList<IGraphicalEntityPart> closestHorizontally = new LinkedList<>();

		for (IGraphicalEntityPart entityPart : entityParts) {
			Rectangle partBounds = entityPart.getFigure().getBounds();
			if (partBounds.contains(bounds) && !entityPart.getChildren().isEmpty()) {
				LinkedList<IGraphicalEntityPart> filtered = filterClosestVertically(entityPart.getChildren(), before, bounds);
				if (!filtered.isEmpty())
					return filtered;
			} else {
				int limit = before ? partBounds.right() : partBounds.x;
				if (limit >= closestX && limit < targetLimit) {
					if (limit > closestX)
						closestHorizontally.clear();
					closestHorizontally.add(entityPart);
					closestX = limit;
				}
			}
		}
		return extractContainerEntityParts(closestHorizontally);
	}
	public static IGraphicalEntityPart getClosestWrappingVertically(List<IGraphicalEntityPart> entityParts, boolean above, Rectangle bounds) {
		throw new UnsupportedOperationException("not implemented yet");
	}
	public static IGraphicalEntityPart getClosestWrappingHorizontally(LinkedList<IGraphicalEntityPart> entityParts, boolean above, Rectangle bounds) {
		LinkedList<IGraphicalEntityPart> candidates = entityParts.stream()
				.filter((p) -> 
					p.getFigure().getBounds().x < bounds.x && bounds.x <= p.getFigure().getBounds().right())
				.collect(Collectors.toCollection(() -> new LinkedList<>()));
		candidates.sort((f, s) -> {
			Rectangle fb = f.getFigure().getBounds();
			Rectangle sb = s.getFigure().getBounds();
			return above ? fb.y - sb.y : sb.bottom() - fb.bottom();
		});
		if (!candidates.isEmpty())
			return candidates.getLast();

		return entityParts.stream().reduce((f, s) -> {
			Rectangle fb = f.getFigure().getBounds();
			Rectangle sb = s.getFigure().getBounds();
			int df = Math.min(Math.abs(fb.x - bounds.x), Math.abs(fb.right() - bounds.x));
			int ds = Math.min(Math.abs(sb.x - bounds.x), Math.abs(sb.right() - bounds.x));
			return df < ds ? f : s;
		}).orElse(null);
	}

	public static IGraphicalEntityPart getClosestAbove(IEntityPartViewer viewer, IGraphicalEntityPart entityPart) {
		return getClosestAbove(viewer, entityPart.getFigure());
	}
	public static IGraphicalEntityPart getClosestAbove(IEntityPartViewer viewer, IFigure figure) {
		return getClosestAbove(viewer, figure.getBounds());
	}
	@SuppressWarnings("unchecked")
	public static IGraphicalEntityPart getClosestAbove(IEntityPartViewer viewer, Rectangle bounds) {
		return getClosestAbove(viewer.getContents().getChildren(), bounds);
	}
	public static IGraphicalEntityPart getClosestAbove(List<IGraphicalEntityPart> entityParts, Rectangle bounds) {
		if (entityParts.isEmpty())
			throw new IllegalArgumentException("empty list");

		return getClosestWrappingHorizontally(filterClosestVertically(entityParts, true, bounds), true, bounds);
	}

	public static IGraphicalEntityPart getClosestBelow(IEntityPartViewer viewer, IGraphicalEntityPart entityPart) {
		return getClosestBelow(viewer, entityPart.getFigure());
	}
	public static IGraphicalEntityPart getClosestBelow(IEntityPartViewer viewer, IFigure figure) {
		return getClosestBelow(viewer, figure.getBounds());
	}
	@SuppressWarnings("unchecked")
	public static IGraphicalEntityPart getClosestBelow(IEntityPartViewer viewer, Rectangle bounds) {
		return getClosestBelow(viewer.getContents().getChildren(), bounds);
	}
	public static IGraphicalEntityPart getClosestBelow(List<IGraphicalEntityPart> entityParts, Rectangle bounds) {
		if (entityParts.isEmpty())
			throw new IllegalArgumentException("empty list");

		return getClosestWrappingHorizontally(filterClosestVertically(entityParts, false, bounds), false, bounds);
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
