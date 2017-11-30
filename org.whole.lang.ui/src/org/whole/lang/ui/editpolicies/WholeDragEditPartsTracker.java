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
package org.whole.lang.ui.editpolicies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Cursor;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeDragEditPartsTracker extends DragEditPartsTracker {
	public static final String REQ_SHARE = new String(RequestConstants.REQ_CLONE);
	public static final int MODIFIER_CLONE;
	public static final int MODIFIER_SHARE;

	static {
		if (SWT.getPlatform().equals("cocoa")) {//$NON-NLS-1$
			MODIFIER_CLONE = SWT.ALT;
			MODIFIER_SHARE = SWT.CTRL;
		} else {
			MODIFIER_CLONE = SWT.CTRL;
			MODIFIER_SHARE = SWT.ALT;
		}
	}


	protected boolean shareActive;

	public WholeDragEditPartsTracker(EditPart sourceEditPart) {
		super(sourceEditPart);
		shareActive = false;
	}

	protected boolean acceptClone(KeyEvent e) {
		return isInState(STATE_DRAG_IN_PROGRESS
		  | STATE_ACCESSIBLE_DRAG
		  | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)
			&& e.keyCode == MODIFIER_CLONE;
	}
	protected boolean acceptShare(KeyEvent e) {
		return isInState(STATE_DRAG_IN_PROGRESS
		  | STATE_ACCESSIBLE_DRAG
		  | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)
			&& e.keyCode == MODIFIER_SHARE;
	}
	protected boolean acceptSHIFT(KeyEvent e) {
		return isInState(STATE_DRAG_IN_PROGRESS
		  | STATE_ACCESSIBLE_DRAG
		  | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)
			&& e.keyCode == SWT.SHIFT;
	}


	protected boolean handleKeyDown(KeyEvent e) {
		if (acceptArrowKey(e))
			return super.handleKeyDown(e);

		setAutoexposeHelper(null);
		if (acceptClone(e)) {
			setCloneActive(true);
			handleDragInProgress();
			return true;
		} else if (acceptShare(e)) {
			setShareActive(true);
			handleDragInProgress();
			return true;
		} else if (acceptSHIFT(e)) {
			handleDragInProgress();
			return true;
		} else
			return false;	
	}

	protected boolean handleKeyUp(KeyEvent e) {
		if (acceptArrowKey(e))
			return super.handleKeyUp(e);
		
		if (acceptClone(e)) {
			setCloneActive(false);
			handleDragInProgress();
			return true;
		} else if (acceptShare(e)) {
			setShareActive(false);
			handleDragInProgress();
			return true;
		} else if (acceptSHIFT(e)) {
			handleDragInProgress();
			return true;
		} else
			return false;
	}

	protected void buttonUpReveal(int button) {
	}

	@Override
	protected boolean isInState(int state) {
		switch (setStateBehavior) {
		case normal:
		default:
			return super.isInState(state);
		case setState:
			return false;
		case captureSourceDimensions:
			return (state & (STATE_INITIAL|STATE_DRAG)) != 0;
		}
	}
	protected SetStateBehavior setStateBehavior = SetStateBehavior.normal;
	protected enum SetStateBehavior {
		normal, setState, captureSourceDimensions
	}

	protected void setState(int state) {
		boolean check = isInState(STATE_INITIAL);
		
		//FIXME workaround for calling super.super.setState(state)
		setStateBehavior = SetStateBehavior.setState;
		super.setState(state);
		setStateBehavior = SetStateBehavior.normal;
		
		if (isInState(STATE_ACCESSIBLE_DRAG | STATE_DRAG_IN_PROGRESS
				| STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			if (getCurrentInput().isModKeyDown(MODIFIER_CLONE)) {
				setCloneActive(true);
				handleDragInProgress();
			} else if (getCurrentInput().isModKeyDown(MODIFIER_SHARE)) {
				setShareActive(true);
				handleDragInProgress();
			}
		}
		
		if (check && isInState(STATE_DRAG | STATE_ACCESSIBLE_DRAG 
				| STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			//FIXME workaround for calling captureSourceDimensions();
			setStateBehavior = SetStateBehavior.captureSourceDimensions;
			super.setState(getState());
			setStateBehavior = SetStateBehavior.normal;
		}
	}

	protected Request createTargetRequest() {
		if (isShareActive())
			return new ChangeBoundsRequest(REQ_SHARE);
		else
			return super.createTargetRequest();
	}

	protected Command getCommand() {
		if (!isShareActive())
			return super.getCommand();
		
		CompoundCommand command = new CompoundCommand();
		command.setDebugLabel("Drag Object Tracker");//$NON-NLS-1$

		Request request = getTargetRequest();
		
		request.setType(REQ_SHARE);

		if (!isMove()) {
			if (getTargetEditPart() == null)
				command.add(UnexecutableCommand.INSTANCE);
			else 
				command.add(getTargetEditPart().getCommand(getTargetRequest()));
		}
		
		return command;
	}

	
	protected String getCommandName() {
		if (isShareActive())
			return REQ_SHARE;
		else
			return super.getCommandName();
	}

	protected Cursor getDefaultCursor() {
		if (isShareActive())
			return SharedCursors.CURSOR_TREE_ADD; // TODO replace with custom pointer
		return super.getDefaultCursor();
	}

	public boolean isShareActive() {
		return shareActive;
	}

	public void setShareActive(boolean shareActive) {
		if (this.shareActive == shareActive)
			return;
		eraseSourceFeedback();
		eraseTargetFeedback();
		this.shareActive = shareActive;
	}

	@Override
	protected void performConditionalSelection() {
		// override to disable direct edit
		if (getSourceEditPart().getSelected() == EditPart.SELECTED_NONE)
			performSelection();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void performSelection() {
		if (!getCurrentInput().isShiftKeyDown())
			super.performSelection();

		if (hasSelectionOccurred())
			return;
		
		setFlag(FLAG_SELECTION_PERFORMED, true);
		IEntityPartViewer viewer = (IEntityPartViewer) getCurrentViewer();

		List<IEntityPart> selectedParts = viewer.getSelectedEditParts();
		IEntityPart startPart = selectedParts.get(selectedParts.size()-1);
		EditPart endPart = getSourceEditPart();
		EditPart parentPart = startPart.getParent();
		if (parentPart != null && endPart != startPart && parentPart == endPart.getParent()) {
			LinkedList<IEntityPart> appendParts = new LinkedList<IEntityPart>();
			int endIndex = -1, startIndex = -1;

			List<IEntityPart> children = parentPart.getChildren();
			for (int i = 0; i < children.size(); i++) {
				IEntityPart child = children.get(i);
				if (child == startPart)
					startIndex = i;
				else if (child == endPart)
					endIndex = i;

				if (startIndex != -1 && endIndex == -1 && i > startIndex)
					appendParts.addLast(child);
				else if (startIndex == -1 && endIndex != -1)
					appendParts.addFirst(child);
				else if (startIndex != -1 && endIndex != -1) {
					if (startIndex < endIndex)
						appendParts.addLast(child);
					break;					
				}
			}

			for (IEntityPart entityPart : appendParts)
				viewer.appendSelection(entityPart);
		} else
			viewer.appendSelection(endPart);
	}
}
