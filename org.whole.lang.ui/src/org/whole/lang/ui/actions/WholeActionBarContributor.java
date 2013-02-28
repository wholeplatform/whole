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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightRetargetAction;
import org.eclipse.gef.ui.actions.MatchWidthRetargetAction;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;
import org.whole.lang.ui.feedback.FeedbackBarConstants;

/**
 * @author Riccardo Solmi
 */
public class WholeActionBarContributor extends ActionBarContributor implements IGlobalActionRegistryListener {

	protected void buildActions() {
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());

		addRetargetAction(new DeleteRetargetAction());

		addRetargetAction(new ZoomInRetargetAction());
		addRetargetAction(new ZoomOutRetargetAction());

		addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));

		addRetargetAction(new MatchWidthRetargetAction());
		addRetargetAction(new MatchHeightRetargetAction());

		addRetargetAction(new RetargetAction(
				FeedbackBarConstants.BOTH, 
				"&Both", IAction.AS_RADIO_BUTTON));
		
		addRetargetAction(new RetargetAction(
				FeedbackBarConstants.VERTICAL, 
				"&Vertical", IAction.AS_RADIO_BUTTON));

		addRetargetAction(new RetargetAction(
				FeedbackBarConstants.HORIZONTAL, 
				"&Horizontal", IAction.AS_RADIO_BUTTON));

		addRetargetAction(new RetargetAction(
				FeedbackBarConstants.NONE, 
				"&None", IAction.AS_RADIO_BUTTON));

		addRetargetAction(new RetargetAction(
				GEFActionConstants.TOGGLE_RULER_VISIBILITY, 
				"&Rulers", IAction.AS_CHECK_BOX));

		addRetargetAction(new RetargetAction(
				GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, 
				"Snap to Geo&metry", IAction.AS_CHECK_BOX));

		addRetargetAction(new RetargetAction(
				GEFActionConstants.TOGGLE_GRID_VISIBILITY, 
				"&Grid", IAction.AS_CHECK_BOX));

		for(IConfigurationElement element : GlobalActionRegistry.getGlobalActionConfigurations())
			addRetargetAction(GlobalActionRegistry.createRetargetAction(element));
	}

	protected void declareGlobalActionKeys() {
		addGlobalActionKey(ActionFactory.CUT.getId());
		addGlobalActionKey(ActionFactory.COPY.getId());
		addGlobalActionKey(ActionFactory.PASTE.getId());
		addGlobalActionKey(ActionFactory.FIND.getId());
		addGlobalActionKey(ActionFactory.PRINT.getId());
		addGlobalActionKey(ActionFactory.SELECT_ALL.getId());
		addGlobalActionKey(ActionFactory.REVERT.getId());
	}

	public void contributeToToolBar(IToolBarManager toolBar) {
		toolBar.add(getAction(ActionFactory.UNDO.getId()));
		toolBar.add(getAction(ActionFactory.REDO.getId()));

		toolBar.add(new Separator());

		toolBar.add(new ZoomComboContributionItem(getPage(), new String[] {
				ZoomManager.FIT_ALL, ZoomManager.FIT_HEIGHT, ZoomManager.FIT_WIDTH
		}));

		AlignmentDropDownAction alignmentsAction = new AlignmentDropDownAction(getActionRegistry());
		addRetargetAction(alignmentsAction);
		toolBar.add(alignmentsAction);

		toolBar.add(new Separator());
		
		for(IConfigurationElement element : GlobalActionRegistry.getGlobalActionConfigurations())
			toolBar.add(getAction(GlobalActionRegistry.getGlobalActionId(element)));
	}

	public void contributeToMenu(IMenuManager menuBar) {
		super.contributeToMenu(menuBar);
		createViewMenu(menuBar);
		createOperationMenu(menuBar);
	}

	private void createOperationMenu(IMenuManager menuBar) {
		if (menuBar.find(IWorkbenchActionConstants.M_WINDOW) == null)
			return;

		MenuManager wholeMenu = new MenuManager("&Operation");
		for(IConfigurationElement element : GlobalActionRegistry.getGlobalActionConfigurations())
			wholeMenu.add(getAction(GlobalActionRegistry.getGlobalActionId(element)));
		menuBar.insertBefore(IWorkbenchActionConstants.M_WINDOW, wholeMenu);
	}

	protected void createViewMenu(IMenuManager menuBar) {
		if (menuBar.find(IWorkbenchActionConstants.M_EDIT) == null)
			return;

		MenuManager viewMenu = new MenuManager("&View");
		viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));
		viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));

		viewMenu.add(new Separator());

		viewMenu.add(createFeedbackSubMenu());
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_RULER_VISIBILITY));
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
		menuBar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
	}

	protected IMenuManager createFeedbackSubMenu() {
		IMenuManager feedbackMenu = new MenuManager("&Feedback Bars");
		feedbackMenu.add(getAction(FeedbackBarConstants.BOTH));
		feedbackMenu.add(getAction(FeedbackBarConstants.VERTICAL));
		feedbackMenu.add(getAction(FeedbackBarConstants.HORIZONTAL));
		feedbackMenu.add(getAction(FeedbackBarConstants.NONE));
		return feedbackMenu;
	}

	@Override
	public void dispose() {
		GlobalActionRegistry.addRegistryListener(this);
		super.dispose();
	}

	@Override
	public void init(IActionBars bars) {
		super.init(bars);
		GlobalActionRegistry.addRegistryListener(this);
	}

	public void registryChanged(GlobalActionRegistryEvent event) {
		if (event.getType() == GlobalActionRegistryEvent.ADDED) {
			addRetargetAction(GlobalActionRegistry.createRetargetAction(event.getElement()));
			IAction action = getAction(GlobalActionRegistry.getGlobalActionId(event.getElement()));
			IToolBarManager toolBar =  getActionBars().getToolBarManager();
			if(toolBar != null)
				toolBar.add(action);
			IMenuManager menuBar = getActionBars().getMenuManager();
			if (menuBar != null)
				menuBar.findMenuUsingPath("Whole").add(action);
			getActionBars().updateActionBars();
		} else {
			// TODO add global action remove event handling
		}
	}
}
