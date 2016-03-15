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
package org.whole.lang.ui.editparts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractContentPanePart extends AbstractPart {

	public ContentPaneFigure getContentPaneFigure() {
		return (ContentPaneFigure) getFigure();
	}

	public IFigure getContentPane(EditPart childEditPart, int index) {
		return getContentPane(index);
	}
	public IFigure getContentPane(EditPart childEditPart) {
		IFigure childFigure = ((GraphicalEditPart) childEditPart).getFigure();
		IFigure childParentFigure = childFigure.getParent();
		
		IEntityFigure cpFigure = getContentPaneFigure();
		for (int i=0; i<cpFigure.getContentPanesSize(); i++)
			if (childParentFigure == cpFigure.getContentPane(i))
				return childParentFigure;

		return getContentPane();
	}
	public IFigure getContentPane(int index) {
		return getContentPaneFigure().getContentPane(index);
	}
	public IFigure getContentPane() {
		return getContentPaneFigure().getContentPane(0);
	}


	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		getContentPane(childEditPart, index).add(child);
	}
	protected void removeChildVisual(EditPart childEditPart) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		getContentPane(childEditPart).remove(child);
	}
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		getContentPane(child).setConstraint(childFigure, constraint);
	}
	@SuppressWarnings("unchecked")
	protected void reorderChild(EditPart child, int index) {
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		LayoutManager layout = getContentPane(child).getLayoutManager();
		Object constraint = null;
		if (layout != null)
			constraint = layout.getConstraint(childFigure);

		removeChildVisual(child);
		List<EditPart> children = getChildren();
		children.remove(child);
		children.add(index, child);
		addChildVisual(child, index);
		setLayoutConstraint(child, childFigure, constraint);
	}
}
