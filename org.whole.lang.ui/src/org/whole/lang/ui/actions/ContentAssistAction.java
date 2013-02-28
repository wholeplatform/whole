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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Enrico Persiani
 */
public class ContentAssistAction extends AbstractLazySelectionAction {
	public static final String ID = ContentAssistAction.class.getName();
	public ContentAssistAction(IWorkbenchPart part) {
		super(part);
	}

	@Override
	protected void init() {
		setId(ID);
	}

	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		return selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IGraphicalEntityPart; 
	}

	@Override
	public void run() {
		GraphicalViewer graphicalViewer = getGraphicalViewer();
		Shell shell = graphicalViewer.getControl().getShell();
		IGraphicalEntityPart entityPart = (IGraphicalEntityPart) graphicalViewer.getFocusEditPart();

		MenuManager menuManager = createMenuManager(shell);
		fillContentAssistMenu(entityPart, menuManager);
		Menu menu = menuManager.createContextMenu(shell);
    	menu.setLocation(calculateMenuLocation(entityPart));
    	menu.setVisible(true);
	}

	protected MenuManager createMenuManager(final Shell shell) {
		final MenuManager menuManager = new MenuManager();

		menuManager.addMenuListener(new IMenuListener2() {
			public void menuAboutToHide(IMenuManager manager) {
				shell.getDisplay().asyncExec(new Runnable() {
					public void run() {
						menuManager.removeAll();
						menuManager.dispose();
					}
				});
			}
			public void menuAboutToShow(IMenuManager manager) {
			}
		});
		return menuManager;
	}

	protected static final Action EMPTY_CONTENT_ASSIST_ACTION = new Action("No content assist") {};
	protected void fillContentAssistMenu(IGraphicalEntityPart entityPart, MenuManager menuManager) {
		WholeGraphicalViewer graphicalViewer = (WholeGraphicalViewer) getGraphicalViewer();
		WholeActionFactory actionFactory = graphicalViewer.getActionFactory();
		IGEFEditorKit editorKit = (IGEFEditorKit) UIUtils.getEditorKit(entityPart);
		ImmutableSelectionProvider provider = new ImmutableSelectionProvider(entityPart);

		actionFactory.fillValueAssistMenu(menuManager, provider, editorKit);

		if (!menuManager.isEmpty())
			menuManager.add(new Separator());

		actionFactory.fillEntityAssistMenu(menuManager, provider, editorKit);

		if (menuManager.isEmpty())
			menuManager.add(EMPTY_CONTENT_ASSIST_ACTION);
	}

	@SuppressWarnings("unchecked")
	protected org.eclipse.swt.graphics.Point calculateMenuLocation(IGraphicalEntityPart entityPart) {
		GraphicalViewer graphicalViewer = getGraphicalViewer();
		IFigure figure = entityPart.getFigure();
		boolean horizontal = false;

		int position = getHilightPosition(entityPart);
		if (position != -1)
			horizontal = ((IEntityLayout) figure.getLayoutManager()).isHorizontal();

		Rectangle bounds = figure.getBounds();
		Point location = horizontal ? bounds.getBottomLeft() : bounds.getTopRight();
		figure.translateToAbsolute(location);

		if (position > 0) {
			IEntity child = entityPart.getModelEntity().wGet(position-1);
			IGraphicalEntityPart childPart = (IGraphicalEntityPart) ModelObserver.getObserver(child, graphicalViewer.getEditPartRegistry());
			figure = childPart.getFigure();
			org.eclipse.draw2d.geometry.Point childLocation = figure.getBounds().getBottomRight();
			figure.translateToAbsolute(childLocation);
			if (horizontal)
				location.x = childLocation.x;
			else
				location.y = childLocation.y;
		}
		FigureCanvas canvas = (FigureCanvas) graphicalViewer.getControl();
		Dimension viewportSize = canvas.getViewport().getSize();
		return canvas.toDisplay(Math.min(location.x, viewportSize.width), Math.min(location.y, viewportSize.height));
	}
}
