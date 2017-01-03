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
package org.whole.lang.e4.ui.actions;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Enrico Persiani
 */
public class LinkToEditorAction extends Action {
	protected ILinkable linkable;
	protected LinkTypeAction selectedAction;

	public LinkToEditorAction() {
		super("linkToEditor", Action.AS_DROP_DOWN_MENU);

		List<IContributionItem> items = new ArrayList<IContributionItem>();
		for (LinkType linkType : LinkType.values()) {
			LinkTypeAction action = new LinkTypeAction(linkType);
			IContributionItem item = new ActionContributionItem(action);
			items.add(item);
		}
		setMenuCreator(new LinkToEditorMenuCreator(items));
	}
	
	public void setLinkable(ILinkable linkable) {
		this.linkable = linkable;
	}
	public ILinkable getLinkable() {
		return linkable;
	}

	@Override
	public void run() {
		if (selectedAction != null) {
			update();
			selectedAction.run();
		}
	}

	protected void update() {
		setId(selectedAction.getId());
		setText(selectedAction.getText());
		setToolTipText(selectedAction.getToolTipText());
		setImageDescriptor(selectedAction.getImageDescriptor());
		setDisabledImageDescriptor(selectedAction.getDisabledImageDescriptor());
	}

	private class LinkToEditorMenuCreator extends AbstractContributionItemsMenuCreator {

		public LinkToEditorMenuCreator(List<IContributionItem> items) {
			super(items, true);
			if (!items.isEmpty())
				updateSelectedAction(items.get(0));
		}

		@Override
		protected void itemSelected(IContributionItem item) {
			updateSelectedAction(item);
			run();
		}

		protected void updateSelectedAction(IContributionItem item) {
			selectedAction = (LinkTypeAction) ((ActionContributionItem) item).getAction();
			update();
		}
	}

	public class LinkTypeAction extends Action {
		protected LinkType linkType;

		public LinkTypeAction(LinkType linkType) {
			super(null);

			this.linkType = linkType;

			switch (linkType) {
			case NOT_LINKED:
				setText("Unlink");
				setToolTipText("Not linked");
				try {
					setImageDescriptor(ImageDescriptor.createFromURL(new URL(IE4UIConstants.NOT_LINKED_URI)));
				} catch (Exception e) {
				}
				break;
			case FIXED_PART:
				setText("Link to fixed editor");
				setToolTipText("Link to fixed editor");
				try {
					setImageDescriptor(ImageDescriptor.createFromURL(new URL(IE4UIConstants.LINKED_TO_EDITOR_URI)));
				} catch (Exception e) {
				}
				break;
			case FIXED_PART_SELECTION:
				setText("Link to fixed editor selection");
				setToolTipText("Linked to fixed editor selection");
				try {
					setImageDescriptor(ImageDescriptor.createFromURL(new URL(IE4UIConstants.LINKED_TO_EDITOR_URI)));
				} catch (Exception e) {
				}
				break;
			case ACTIVE_PART:
				setText("Link to active editor");
				setToolTipText("Linked to active editor");
				try {
					setImageDescriptor(ImageDescriptor.createFromURL(new URL(IE4UIConstants.LINKED_TO_ACTIVE_EDITOR_URI)));
				} catch (Exception e) {
				}
				break;
			}
		}

		@Override
		public void run() {
			if (linkable != null)
				linkable.updateLinkType(linkType);
		}
	};
}
