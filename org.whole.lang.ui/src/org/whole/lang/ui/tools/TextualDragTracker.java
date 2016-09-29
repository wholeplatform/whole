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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.tools.SimpleDragTracker;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Cursor;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.figures.ITextualFigure;
import org.whole.lang.ui.keys.IKeyHandler;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/** 
 * @author Enrico Persiani
 */
public class TextualDragTracker extends SimpleDragTracker {
	private static final int STATE_SELECT = SimpleDragTracker.MAX_STATE << 1;
	private static final int STATE_SWIPE = SimpleDragTracker.MAX_STATE << 2;

	private ITextualEntityPart beginPart;
	private ITextualEntityPart endPart;

	private int start;
	private int end;

	public TextualDragTracker() {
	}

	@Override
	protected List<IEntityPart> createOperationSet() {
		IEntityPartViewer viewer = (IEntityPartViewer) getCurrentViewer();
		return Collections.<IEntityPart>singletonList(viewer.getFocusEntityPart());
	}

	@Override
	protected Cursor calculateCursor() {
		return SharedCursors.IBEAM;
	}

	@Override
	protected String getCommandName() {
		return "Drop Text";
	}

	protected ITextualEntityPart getTextualEntityPart() {
		if (beginPart != null)
			return beginPart;

		EditPart target = getCurrentViewer().findObjectAt(getLocation());
		if (!(target instanceof ITextualEntityPart))
			return null;

		return (ITextualEntityPart) target;
	}

	@Override
	protected boolean handleButtonDown(int button) {
		ITextualEntityPart textualEntityPart = getTextualEntityPart();
		if (button != 1 || textualEntityPart == null) {
			beginPart = endPart = null;
			start = end = 0;
			setState(STATE_INVALID);
			return handleInvalidInput();
		} else {
			beginPart = endPart = textualEntityPart;
			CaretUpdater.sheduleSyncUpdate(getCurrentViewer(), beginPart.getModelEntity(), getLocation(), true);
			start = textualEntityPart.getCaretPosition();
			return stateTransition(STATE_INITIAL, STATE_SELECT);
		}
	}

	protected boolean handleTripleClick(int button) {
		ITextualEntityPart textualEntityPart = getTextualEntityPart();
		if (button == 1 && textualEntityPart != null) {
			IGEFEditorKit editorkit = (IGEFEditorKit) textualEntityPart.getModelEntity().wGetEditorKit();
			EditPoint editPoint = new EditPoint(textualEntityPart, textualEntityPart.getCaretPosition());
			IKeyHandler keyHandler = editorkit.getKeyHandler();
			IWholeSelection selection = keyHandler.calculateTripleClickSelection(editPoint);
			performSelectionUpdate(selection, true);
			return true;
		}
		return false;
	}

	@Override
	protected boolean handleDoubleClick(int button) {
		ITextualEntityPart textualEntityPart = getTextualEntityPart();
		if (button == 1 && textualEntityPart != null) {
			IGEFEditorKit editorkit = (IGEFEditorKit) textualEntityPart.getModelEntity().wGetEditorKit();
			EditPoint editPoint = new EditPoint(textualEntityPart, textualEntityPart.getCaretPosition());
			IKeyHandler keyHandler = editorkit.getKeyHandler();
			IWholeSelection selection = keyHandler.calculateDoubleClickSelection(editPoint);
			performSelectionUpdate(selection, true);
			return true;
		}
		return super.handleDoubleClick(button);
	}

	@Override
	protected boolean handleDragStarted() {
		return stateTransition(STATE_SELECT, STATE_SWIPE);
	}

	@Override
	protected boolean handleDragInProgress() {
		EditPartViewer viewer = getCurrentViewer();
		ITextualEntityPart textualEntityPart = getTextualEntityPart();
		if (textualEntityPart == null)
			return false;

		EditPart overPart = viewer.findObjectAt(getLocation());
		if (overPart == endPart) {
			end = textualEntityPart.getCaretPosition();
			if (start <= end)
				performSelectionUpdate(new SelectionRange(textualEntityPart, start, end), false);
			else {
				performSelectionUpdate(new SelectionRange(textualEntityPart, end, start), false);
			}
		} else {
			ITextualFigure textualFigure = textualEntityPart.getTextualFigure();
			Rectangle textBounds = textualFigure.getTextBounds();
			textualFigure.translateToAbsolute(textBounds);

			Point mouseLocation = getLocation();

			mouseLocation.x = Math.max(mouseLocation.x, textBounds.x);
			mouseLocation.x = Math.min(mouseLocation.x, textBounds.right()-1);
			mouseLocation.y = Math.max(mouseLocation.y, textBounds.y);
			mouseLocation.y = Math.min(mouseLocation.y, textBounds.bottom()-1);

			textualEntityPart.updateCaret(mouseLocation);
			end = textualEntityPart.getCaretPosition();

			if (start <= end)
				performSelectionUpdate(new SelectionRange(textualEntityPart, start, end), mouseLocation, false);
			else {
				performSelectionUpdate(new SelectionRange(textualEntityPart, end, start), mouseLocation, false);
			}

		}
		return super.handleDragInProgress();
	}

	private void performSelectionUpdate(IWholeSelection selection, boolean caretOnSelectionEnd) {
		performSelectionUpdate(selection, null, caretOnSelectionEnd);
	}

	private void performSelectionUpdate(IWholeSelection selection, Point location, boolean caretOnSelectionEnd) {
		EditPartViewer viewer = getCurrentViewer();
		IEntityPart focusPart = null;
		if (selection.size() > 0) {
			IWholeSelection last = selection.get(selection.size()-1);
			int caretPosition = -1;
			switch (last.getKind()) {
			case RANGE:
				caretPosition = last.getEndPosition();
			case PART:
				IEntityPart lastPart = last.getPart();
				if (lastPart instanceof ITextualEntityPart) {
					ITextualEntityPart caretPart = (ITextualEntityPart) lastPart;
					if (caretOnSelectionEnd) {
						caretPosition = caretPosition < 0 ? caretPart.getCaretPositions(): caretPosition;
						CaretUpdater.sheduleSyncUpdate(getCurrentViewer(), lastPart.getModelEntity(), caretPosition, true);
					} else
						CaretUpdater.sheduleSyncUpdate(getCurrentViewer(), lastPart.getModelEntity(), location != null ? location : getLocation(), true);
					// update focus only if instance of ICaretEntityPart
					focusPart = lastPart;
				}
			default:
				break;
			}
		}
		List<IEntityPart> partList = new ArrayList<IEntityPart>();
		for (int i=0; i<selection.size(); i++) {
			IWholeSelection sel = selection.get(i);
			switch (sel.getKind()) {
			case RANGE:
				((ITextualEntityPart)sel.getPart()).setSelectionRange(sel.getStartPosition(), sel.getEndPosition());
				partList.add(sel.getPart());
				break;
			case PART:
				IEntityPart part = sel.getPart();
				if (part instanceof ITextualEntityPart)
					((ITextualEntityPart)part).setSelectionRange(0, ((ITextualEntityPart)part).getCaretPositions());
				partList.add(sel.getPart());
				break;
			default:
				break;
			}
		}
		viewer.setSelection(new StructuredSelection(partList));
		viewer.setFocus(focusPart);
	}

	public void mouseTripleClick(MouseEvent me, EditPartViewer viewer) {
		if (me.button > 5 || !isViewerImportant(viewer))
			return;
		setViewer(viewer);
		getCurrentInput().setInput(me);

		handleTripleClick(me.button);
	}
}
