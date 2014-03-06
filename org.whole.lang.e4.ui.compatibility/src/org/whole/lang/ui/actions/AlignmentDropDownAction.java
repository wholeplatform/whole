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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.LabelRetargetAction;

/**
 * @author Enrico Persiani
 */
public class AlignmentDropDownAction extends LabelRetargetAction {
	private List<IContributionItem> alignmentItems;

	public AlignmentDropDownAction(ActionRegistry actionRegistry) {
		super(null, null);
		alignmentItems = new ArrayList<IContributionItem>();
		init(actionRegistry);
		setMenuCreator(new AlignmentActionsMenuCreator(alignmentItems));
	}

	private void init(ActionRegistry actionRegistry) {
		IAction alignLeftAction = actionRegistry.getAction(GEFActionConstants.ALIGN_LEFT);
		add(alignLeftAction);
		add(actionRegistry.getAction(GEFActionConstants.ALIGN_CENTER));
		add(actionRegistry.getAction(GEFActionConstants.ALIGN_RIGHT));
		add(new Separator());
		add(actionRegistry.getAction(GEFActionConstants.ALIGN_TOP));
		add(actionRegistry.getAction(GEFActionConstants.ALIGN_MIDDLE));
		add(actionRegistry.getAction(GEFActionConstants.ALIGN_BOTTOM));
		add(new Separator());
		add(actionRegistry.getAction(GEFActionConstants.MATCH_WIDTH));
		add(actionRegistry.getAction(GEFActionConstants.MATCH_HEIGHT));
		updateDefaultAction(alignLeftAction);
	}

	protected void add(IContributionItem item) {
		alignmentItems.add(item);
	}

	protected void add(IAction action) {
		add(new ActionContributionItem(action));
	}

	protected void updateDefaultAction(IAction action) {
		setId(action.getId());
		setText(action.getText());
		setToolTipText(action.getToolTipText());
		setImageDescriptor(action.getImageDescriptor());
		setDisabledImageDescriptor(action.getDisabledImageDescriptor());
		setActionHandler(action);
	}

	private class AlignmentActionsMenuCreator extends AbstractContributionItemsMenuCreator {
		public AlignmentActionsMenuCreator(List<IContributionItem> items) {
			super(items, false);
		}

		@Override
		protected void itemSelected(IContributionItem item) {
			updateDefaultAction(((ActionContributionItem) item).getAction());
		}
	}
}
