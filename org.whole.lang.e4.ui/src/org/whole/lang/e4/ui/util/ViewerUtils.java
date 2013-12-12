/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.util;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ExposeHelper;
import org.eclipse.gef.GraphicalEditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.ExtendedExposeHelper;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class ViewerUtils {
	public static void reveal(IEntityPartViewer viewer, EditPart part) {
		if (part == null)
			return;

		exposeEditPart(viewer, part);
		viewer.flush();
		exposeRegion(viewer, part);
	}

	public static void exposeEditPart(IEntityPartViewer viewer, EditPart part) {
		EditPart parentPart = part.getParent();
		EditPart childPart = part;

		while (parentPart != null) {
			ExposeHelper exposeHelper = (ExposeHelper) parentPart.getAdapter(ExposeHelper.class);
			if (exposeHelper instanceof ExtendedExposeHelper)
				((ExtendedExposeHelper) exposeHelper).exposeChild(childPart);
			else if (exposeHelper != null)
				exposeHelper.exposeDescendant(part);
			childPart = parentPart;
			parentPart = childPart.getParent();
		}

		AccessibleEditPart accessiblePart;
		if ((accessiblePart = (AccessibleEditPart) part.getAdapter(AccessibleEditPart.class)) != null)
			viewer.getControl().getAccessible().setFocus(accessiblePart.getAccessibleID());
	}

	public static void exposeRegion(IEntityPartViewer viewer, EditPart part) {
		Viewport port = getFigureCanvas(viewer).getViewport();
		IFigure target = ((GraphicalEditPart) part).getFigure();
		Rectangle exposeRegion = target.getBounds().getCopy();
		target = target.getParent();
		while (target != null && target != port) {
			target.translateToParent(exposeRegion);
			target = target.getParent();
		}

		Rectangle targetRegion = exposeRegion.getCopy().shrink(5, 5); //++
		if (!port.getClientArea().intersects(targetRegion)) { //++
			Dimension viewportSize = port.getClientArea().getSize();

			exposeRegion.expand(5, 5);

			Point topLeft = exposeRegion.getTopLeft();
			Point bottomRight = exposeRegion.getBottomRight().translate(viewportSize.getNegated());
			Point finalLocation = new Point();
			if (viewportSize.width < exposeRegion.width)
				finalLocation.x = Math.min(bottomRight.x, Math.max(topLeft.x, port.getViewLocation().x));
			else
				finalLocation.x = Math.min(topLeft.x, Math.max(bottomRight.x, port.getViewLocation().x));

			if (viewportSize.height < exposeRegion.height)
				finalLocation.y = Math.min(bottomRight.y, Math.max(topLeft.y, port.getViewLocation().y));
			else
				finalLocation.y = Math.min(topLeft.y, Math.max(bottomRight.y, port.getViewLocation().y));

			getFigureCanvas(viewer).scrollSmoothTo(finalLocation.x, finalLocation.y);
		}
	}

	private static FigureCanvas getFigureCanvas(IEntityPartViewer viewer) {
		return (FigureCanvas) viewer.getControl();
	}

	public static void refreshNotation(IEntityPartViewer viewer) {
		FigureCanvas figureCanvas = getFigureCanvas(viewer);
		Viewport viewport = figureCanvas.getViewport();
		viewport.invalidateTree();
		viewport.revalidate();
		figureCanvas.redraw();
	}

	public void rebuildNotation(IEntityPartViewer viewer) {
		viewer.setContents(viewer.getContents().getModel());
	}
	public void rebuildNotation(IEntityPartViewer viewer, IEntity entity) {
		Object editPart = viewer.getEditPartRegistry().get(entity);
		if (editPart == null)
			editPart = viewer.getEditPartRegistry().get(entity.wGetParent().wGet(entity));
		if (editPart instanceof IEntityPart)
			((IEntityPart) editPart).rebuild();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T safeGetProperty(EditPartViewer viewer, String propertyName, T defaultValue) {
		Object propertyValue = viewer.getProperty(propertyName);
		return propertyValue == null ? defaultValue : (T) propertyValue;
	}
}
