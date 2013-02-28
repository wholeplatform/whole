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

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.views.WholeGraphicalPage;
import org.whole.lang.ui.views.WholeGraphicalView;
import org.whole.lang.ui.views.WholeGraphicalView.LinkType;

/**
 * @author Enrico Persiani
 */
public class LinkToEditorAction extends Action {
	protected LinkTypeAction selectedAction;

	public LinkToEditorAction(WholeGraphicalView view) {
		super("linkToEditor", Action.AS_DROP_DOWN_MENU);

		List<IContributionItem> items = new ArrayList<IContributionItem>();
		for (LinkType linkType : LinkType.values()) {
			LinkTypeAction action = new LinkTypeAction(view, linkType);
			IContributionItem item = new ActionContributionItem(action);
			items.add(item);
		}
		setMenuCreator(new LinkToEditorMenuCreator(items));
	}
	
	@Override
	public void run() {
		if (selectedAction != null) {
			selectedAction.update();
			updateAndRun();
		}
	}

	protected void updateAndRun() {
		setId(selectedAction.getId());
		setText(selectedAction.getText());
		setToolTipText(selectedAction.getToolTipText());
		setImageDescriptor(selectedAction.getImageDescriptor());
		setDisabledImageDescriptor(selectedAction.getDisabledImageDescriptor());
		selectedAction.run();
	}

	private class LinkToEditorMenuCreator extends AbstractContributionItemsMenuCreator {

		public LinkToEditorMenuCreator(List<IContributionItem> items) {
			super(items, true);
			if (!items.isEmpty())
				itemSelected(items.get(0));
		}

		@Override
		protected void itemSelected(IContributionItem item) {
			selectedAction = (LinkTypeAction) ((ActionContributionItem) item).getAction();
			updateAndRun();
		}

		@Override
		protected void updateItems(List<IContributionItem> items) {
			for (IContributionItem item : items) {
				UpdateAction action = (UpdateAction) ((ActionContributionItem) item).getAction();
				action.update();
			}
		}
	}

	private static class LinkTypeAction extends Action implements UpdateAction {
		private WholeGraphicalView view;
		private LinkType linkType;
		private boolean update = true;

		public LinkTypeAction(WholeGraphicalView view, LinkType linkType) {
			super(null);

			this.view = view;
			this.linkType = linkType;

			switch (linkType) {
			case NOT_LINKED:
				update = false;
				setText("Unlink");
				setToolTipText("Not linked");
				setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/not_linked.gif"));
				break;
			case FIXED_EDITOR:
				setText("Link to fixed editor");
				setToolTipText("Link to fixed editor");
				setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/link_to_editor.gif"));
				break;
			case FIXED_EDITOR_SELECTION:
				setText("Link to fixed editor selection");
				setToolTipText("Linked to fixed editor selection");
				setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/link_to_editor.gif"));
				break;
			case ACTIVE_EDITOR:
				setText("Link to active editor");
				setToolTipText("Linked to active editor");
				setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/link_to_active_editor.gif"));
				break;
			}
		}

		@Override
		public void run() {
			view.setLinkType(linkType);
			if (update) {
				if (activeEditor instanceof WholeGraphicalEditor) {
					ISelection selection = ((GraphicalViewer) activeEditor.getAdapter(GraphicalViewer.class)).getSelection();
					view.showContentPage(activeEditor);
					WholeGraphicalPage activePage = view.getActivePage();
					if (activePage != null)
						activePage.getViewer().selectionChanged(activeEditor, selection);
				} else if (activeEditor != null)
					view.showDefaultPage();
			}
		}

		private IEditorPart activeEditor = null;
		public void update() {
			activeEditor = UIUtils.getActiveEditor();
			if (linkType.isLinkedToFixedEditor() && activeEditor != null) {
				String target = activeEditor.getEditorInput().getName() +
						(linkType.isLinkedToFixedEditorSelection() ? " selection" : "");
				setText("Link to " + target);
				setToolTipText("Linked to " + target);
				setEnabled(activeEditor instanceof WholeGraphicalEditor);
			} else
				setEnabled(true);
		}
	};
}
