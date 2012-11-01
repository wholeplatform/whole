/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.menu.ContextMenuEntityTypeRequest;
import org.whole.lang.ui.menu.ContextMenuPrototypeRequest;
import org.whole.lang.ui.menu.IContextMenuRequest;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class AbstractLazySelectionAction extends SelectionAction implements Comparable<IAction> {
	public static final ImageDescriptor INSERT_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/insert.gif"); 
	public static final ImageDescriptor REPLACE_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/replace.gif"); 
	public static final ImageDescriptor WRAP_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/wrap.gif"); 
	public static final ImageDescriptor TEXT_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/text.gif"); 
	public static final ImageDescriptor SELECT_STAGE_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/select_stage.gif"); 
	public static final ImageDescriptor SELECT_LANGUAGE_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/select_language.gif"); 
	public static final ImageDescriptor SELECT_PERSISTENCE_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/select_persistence.gif");
	public static final ImageDescriptor IMPORT_FRAGMENT_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/import_fragment.gif"); 

	protected final IEnablerPredicate enablerPredicate; 
	protected final IContextMenuRequest contextMenuRequest;

	public AbstractLazySelectionAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype) {
		super(part);

		this.enablerPredicate = enablerPredicate;
		contextMenuRequest = new ContextMenuPrototypeRequest(prototype);
	}
	public AbstractLazySelectionAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type) {
		super(part);

		this.enablerPredicate = enablerPredicate;
		contextMenuRequest = new ContextMenuEntityTypeRequest(type);
	}

	public AbstractLazySelectionAction(IWorkbenchPart part) {
		super(part);

		this.enablerPredicate = null;
		contextMenuRequest = new ContextMenuPrototypeRequest(null);
	}

	protected final GraphicalViewer getGraphicalViewer() {
		return (GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class);
	}

	public int compareTo(IAction other) {
		return getText().compareTo(other.getText());
	}

	@Override
	public void update() {
		invalidateHilightPosition();
		super.update();
		updateHilightPosition();
	}

	protected void invalidateHilightPosition() {
		contextMenuRequest.setHilightPosition(-1);
	}

	protected void updateHilightPosition() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IHilightable) {
			IHilightable selectedPart = (IHilightable) selectedObjects.get(0);
			contextMenuRequest.setHilightPosition(selectedPart.getHilightPosition());
		}
	}


	protected int getHilightPosition(IEntityPart selectedPart) {
		int position = -1;
		if (selectedPart instanceof IHilightable)
			position = ((IHilightable) selectedPart).getHilightPosition();
		if (position >= 0)
			contextMenuRequest.setHilightPosition(position);
		else
			position = contextMenuRequest.getHilightPosition();
		return position;
	}

	protected Point calculateTargetLocation(IEntityPart targetEntityPart) {
		IFigure figure = ((IGraphicalEntityPart) targetEntityPart).getFigure();
		if (targetEntityPart instanceof IHilightable) {
			int positions = targetEntityPart.getChildren().size();
			int position = getHilightPosition(targetEntityPart);
			Point location;
			if (position == -1 || position == positions) {
				location = figure.getBounds().getBottomRight();
				figure.translateToAbsolute(location);
			} else {
				IFigure childFigure = (IFigure) figure.getChildren().get(position);
				location = childFigure.getBounds().getTopLeft();
				childFigure.translateToAbsolute(location);
			}
			return location;
		} else {
			Point center = figure.getBounds().getCenter();
			figure.translateToAbsolute(center);
			return center;
		}
	}
}
