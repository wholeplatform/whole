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
package org.whole.lang.ui.tools;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.ui.commands.ITextCommand;
import org.whole.lang.ui.commands.TextTransactionCommand;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editpolicies.TextualHilightEditPolicy;
import org.whole.lang.ui.requests.TextualRequest;
import org.whole.lang.ui.util.AnimableRunnable;

/** 
 * @author Enrico Persiani
 */
public class TextualSelectionTool extends SelectionTool implements PositionConstants {
	static final boolean IS_COCOA = "cocoa".equals(SWT.getPlatform());

	protected TextTransactionCommand transactionCommand;
	protected boolean mirrored;
	protected int tripleClickButton;
	protected boolean animationState;

	public TextualSelectionTool() {
		setDefaultCursor(SharedCursors.IBEAM); 
		setUnloadWhenFinished(false);
	}

	protected EditPart getFocusedPart() {
		EditPartViewer viewer = getCurrentViewer();
		return viewer != null ? viewer.getFocusEditPart() : null;
	}

	protected IEditorKit getEditorKit() {
		EditPart target = getFocusedPart();
		if (target == null || !(target instanceof IEntityPart))
			return null;
		return ((IEntityPart) target).getModelEntity().wGetEditorKit();
	}

	protected void resetTransactionCommand() {
		transactionCommand = null;
	}
	protected void performSelectionLocationUpdate(TextualHilightEditPolicy editPolicy) {
			resetTransactionCommand();
			editPolicy.updateHilight(getLocation());
	}

	@Override
	public void setViewer(EditPartViewer viewer) {
		super.setViewer(viewer);
		mirrored = viewer != null && (viewer.getControl().getStyle() & SWT.MIRRORED) != 0;
	}

	@Override
	public void activate() {
		super.activate();
		animationState = AnimableRunnable.enableAnimation(false);
		refreshCursor();
		AbstractPart.setSyncPropertyChange(true);
	}

	@Override
	public void deactivate() {
		AbstractPart.setSyncPropertyChange(false);
		resetTransactionCommand();
		AnimableRunnable.enableAnimation(animationState);
		super.deactivate();
	}

	@Override
	public void mouseDown(MouseEvent e, EditPartViewer viewer) {
		super.mouseDown(e, viewer);
		EditPart targetEditPart = getTargetEditPart();
		if (targetEditPart == null || e.button != 1)
			return;
		EditPolicy editPolicy = targetEditPart.getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if (editPolicy instanceof TextualHilightEditPolicy)
			performSelectionLocationUpdate((TextualHilightEditPolicy) editPolicy);
	}

	@Override
	public void mouseUp(MouseEvent e, EditPartViewer viewer) {
		if (tripleClickButton < 0)
			tripleClickButton = -tripleClickButton;
		else if (tripleClickButton > 0) {
			DragTracker dragTracker = getDragTracker();
			if (dragTracker instanceof TextualDragTracker)
				((TextualDragTracker) dragTracker).mouseTripleClick(e, viewer);
		}
		super.mouseUp(e, viewer);
	}

	@Override
	public void mouseDoubleClick(MouseEvent e, EditPartViewer viewer) {
		super.mouseDoubleClick(e, viewer);
		tripleClickButton = -e.button;
		Display.getCurrent().timerExec(500, new Runnable() {
			public void run() {
				tripleClickButton = 0;
			}
		});
	}

	@Override
	protected boolean handleKeyDown(KeyEvent event) {
		if (isInState(STATE_INITIAL)) {
			handleModelKeyPressed(event);
			if (event.doit)
				doKeyDown(event);
			else
				resetTransactionCommand();
		}
		if (event.doit) {
			//TODO better tracking of focus change in graphical viewer
			EditPart editPart = getTargetEditPart();
			boolean handleKeyDown = super.handleKeyDown(event);
			EditPart focusEditPart = getCurrentViewer().getFocusEditPart();
			if (!focusEditPart.equals(editPart))
				setTargetEditPart(focusEditPart);
			return handleKeyDown;
		}
		return true;
	}

	@Override
	protected boolean handleKeyUp(KeyEvent event) {
		handleModelKeyReleased(event);
		if (event.doit)
			return super.handleKeyUp(event);
		resetTransactionCommand();
		return true;
	}

	protected void doKeyDown(KeyEvent event) {
		int action = 0;

		if (event.keyCode != 0)
			action = lookupAction(event.keyCode | event.stateMask);
		else {
			action = lookupAction(event.character | event.stateMask);
			// check for control characters
			if (action == 0 && (event.stateMask & SWT.CTRL) != 0 && event.character >= 0 && event.character <= 31) {
				// get the character from the CTRL+char sequence, the control
				// key subtracts 64 from the value of the key that it modifies
				int c = event.character + 64;
				action = lookupAction(c | event.stateMask);
			}
		}

		if (action == 0)
			handleTyping(event);
		else
			doAction(action, event);
	}

	protected void doAction(int action, KeyEvent event) {
		event.doit = false;

		switch (action) {
		case ST.DELETE_PREVIOUS:
			event.doit = !handleBackspace();
			break;
		case ST.DELETE_NEXT:
			event.doit = !handleDelete();
			break;
		case ST.LINE_UP:
			event.doit = !handleCaretMove(-1, VERTICAL);
			break;
		case ST.LINE_DOWN:
			event.doit = !handleCaretMove(1, VERTICAL);
			break;
		case ST.COLUMN_PREVIOUS:
			event.doit = !handleCaretMove(-1, HORIZONTAL);
			break;
		case ST.COLUMN_NEXT:
			event.doit = !handleCaretMove(1, HORIZONTAL);
			break;
		case ST.TOGGLE_OVERWRITE:
			toggleOverwrite();
			break;
		case SWT.TAB:
			handleTyping(event);
			break;
		case SWT.LF:
			handleTyping(event);
			break;
		default:
			event.doit = true;
		break;
		}
	}

	protected void handleTyping(KeyEvent event) {
		boolean ignore = false;

		if (IS_COCOA) {
			// Ignore accelerator key combinations (we do not want to
			// insert a character in the text in this instance). Do not
			// ignore COMMAND+ALT combinations since that key sequence
			// produces characters on the mac.
			ignore = (event.stateMask ^ SWT.COMMAND) == 0
			|| (event.stateMask ^ (SWT.COMMAND | SWT.SHIFT)) == 0;
		} else {
			// Ignore accelerator key combinations (we do not want to
			// insert a character in the text in this instance). Don't
			// ignore CTRL+ALT combinations since that is the Alt Gr
			// key on some keyboards.
			ignore = (event.stateMask ^ SWT.ALT) == 0 || (event.stateMask ^ SWT.CTRL) == 0
			|| (event.stateMask ^ (SWT.ALT | SWT.SHIFT)) == 0
			|| (event.stateMask ^ (SWT.CTRL | SWT.SHIFT)) == 0;
		}
		// -ignore anything below SPACE except for line delimiter keys and tab.
		// -ignore DEL
		if (!ignore && event.character > 31 && event.character != SWT.DEL
				|| event.character == SWT.CR || event.character == SWT.LF
				|| event.character == '\t') {
			doInsertContent(event.character);
			event.doit = false;
		}
	}

	protected int lookupAction(int i) {
		switch (i) {
		//Left and Right
		case SWT.ARROW_LEFT:
			return mirrored ? ST.COLUMN_NEXT : ST.COLUMN_PREVIOUS;
		case SWT.ARROW_RIGHT:
			return mirrored ? ST.COLUMN_PREVIOUS : ST.COLUMN_NEXT;
		case SWT.ARROW_RIGHT | SWT.SHIFT:
			return mirrored ? ST.SELECT_COLUMN_PREVIOUS : ST.SELECT_COLUMN_NEXT;
		case SWT.ARROW_LEFT | SWT.SHIFT:
			return mirrored ? ST.SELECT_COLUMN_NEXT : ST.SELECT_COLUMN_PREVIOUS;
		case SWT.ARROW_RIGHT | SWT.CONTROL:
			return mirrored ? ST.WORD_PREVIOUS : ST.WORD_NEXT;
		case SWT.ARROW_RIGHT | SWT.CONTROL | SWT.SHIFT:
			return mirrored ? ST.SELECT_WORD_PREVIOUS : ST.SELECT_WORD_NEXT;
		case SWT.ARROW_LEFT| SWT.CONTROL:
			return mirrored ? ST.WORD_NEXT : ST.WORD_PREVIOUS;
		case SWT.ARROW_LEFT| SWT.CONTROL | SWT.SHIFT:
			return mirrored ? ST.SELECT_WORD_NEXT : ST.SELECT_WORD_PREVIOUS;

		case ST.LINE_END:
		case ST.TOGGLE_OVERWRITE:
		case ST.SELECT_LINE_END:
		case ST.LINE_START:
		case ST.SELECT_LINE_START:
		case ST.PAGE_UP:
		case ST.PAGE_DOWN:
		case ST.SELECT_PAGE_UP:
		case ST.SELECT_PAGE_DOWN:
		case ST.LINE_UP:
		case ST.LINE_DOWN:
		case ST.SELECT_LINE_UP:
		case ST.SELECT_LINE_DOWN:
		case ST.TEXT_END:
		case ST.SELECT_TEXT_END:
		case ST.TEXT_START:
		case ST.SELECT_TEXT_START:
		case ST.DELETE_PREVIOUS:
		case ST.DELETE_NEXT:
		case ST.WINDOW_START:
		case ST.WINDOW_END:
		case ST.SELECT_WINDOW_START:
		case ST.SELECT_WINDOW_END:
		case SWT.TAB | SWT.SHIFT:
		case SWT.TAB:
			return i;

		case SWT.LF:
		case SWT.CR:
			return SWT.LF;
		default:
			break;
		}
		return 0;
	}

	protected boolean handleCaretMove(int positions, int direction) {
		EditPart target = getFocusedPart();
		if (target == null)
			return false;
		EditPolicy editPolicy = target.getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if (editPolicy instanceof TextualHilightEditPolicy) {
			if (direction == HORIZONTAL && ((TextualHilightEditPolicy) editPolicy).moveCaretHorizontally(positions)) {
				resetTransactionCommand();
				return true;
			}
			if (direction == VERTICAL && ((TextualHilightEditPolicy) editPolicy).moveCaretVertically(positions)) {
				resetTransactionCommand();
				return true;
			}
		}
		return false;
	}

	protected boolean handleTextRequest(TextualRequest edit) {
		EditPart target = getFocusedPart();
		if (target == null)
			return false;

		Command command = target.getCommand(edit);
		if (command == null || !command.canExecute())
			return false;

		if (command instanceof ITextCommand) {
			ITextCommand textCommand = (ITextCommand) command;
			if (transactionCommand == null || !transactionCommand.canMerge(textCommand) || !getDomain().getCommandStack().isDirty()) {
				transactionCommand = new TextTransactionCommand();
				transactionCommand.setModel((IEntity) target.getModel());
				transactionCommand.merge(textCommand);
				executeCommand(transactionCommand);
			} else
				transactionCommand.merge(textCommand);
		} else {
			resetTransactionCommand();
			executeCommand(command);
		}
		return true;
	}

	protected void handleModelKeyPressed(KeyEvent event) {
		getCurrentViewer().getKeyHandler().keyPressed(event);
	}
	protected void handleModelKeyReleased(KeyEvent event) {
		getCurrentViewer().getKeyHandler().keyReleased(event);
	}

	protected boolean handleBackspace() {
		return handleTextRequest(TextualRequest.createBackspaceRequest());
	}
	protected boolean handleDelete() {
		return handleTextRequest(TextualRequest.createDeleteRequest());
	}

	private boolean overwrite = false;
	public boolean toggleOverwrite() {
		return overwrite = !overwrite;
	}
	public boolean isOverwrite() {
		return overwrite;
	}
	protected boolean doInsertContent(char ch) {
		return doInsertContent(ch == SWT.CR ? "\n" : Character.toString(ch));
	}
	protected boolean doInsertContent(String content) {
		return handleTextRequest(isOverwrite() ? TextualRequest.createOverwriteRequest(content) : TextualRequest.createInsertRequest(content));
	}

	@Override
	protected Cursor calculateCursor() {
		return getDefaultCursor();
	}
}
