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

import static org.eclipse.draw2d.PositionConstants.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.figures.ITextualFigure;
import org.whole.lang.ui.keys.IKeyHandler;
import org.whole.lang.ui.tools.EditPoint;
import org.whole.lang.ui.tools.IEditPointProvider;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.ui.util.CaretUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class E4NavigationKeyHandler extends E4KeyHandler implements IEditPointProvider {
	public E4NavigationKeyHandler(IEclipseContext context) {
		super(context);
	}

	/**
	 * Returns the list of editparts which are conceptually at the same level of navigation as
	 * the currently focused editpart.  By default, this is the siblings of the focused part.
	 * @return a list of navigation editparts
	 */
	public List<?> getNavigationSiblings() {
		return getFocusEntityPart().getParent().getChildren();
	}


	boolean insertMode = true;
	public boolean isInsertMode() {
		return insertMode;
	}
	public void toggleInsertMode() {
		insertMode = !insertMode;
	}

	/**
	 * Returns the cached node. It is possible that the node is not longer in the viewer but
	 * has not been garbage collected yet.
	 */
	private WeakReference<GraphicalEditPart> cachedNode;
	private GraphicalEditPart getCachedNode() {
		if (cachedNode == null)
			return null;
		if (cachedNode.isEnqueued())
			return null;
		return (GraphicalEditPart)cachedNode.get();
	}
	private void setCachedNode(GraphicalEditPart node) {
		if (node == null)
			cachedNode = null;
		else 
			cachedNode = new WeakReference<GraphicalEditPart>(node);
	}

	/**
	 * Given a connection on a node, this method finds the next (or the previous) connection
	 * of that node.
	 * 
	 * @param	node	The EditPart whose connections are being traversed
	 * @param	current	The connection relative to which the next connection has to be found
	 * @param	forward	<code>true</code> if the next connection has to be found; false otherwise
	 */
	private int counter = 0;
	@SuppressWarnings("unchecked")
	ConnectionEditPart findConnection(GraphicalEditPart node, ConnectionEditPart current, boolean forward) {
		List<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>(node.getSourceConnections());
		connections.addAll(node.getTargetConnections());
		if (connections.isEmpty())
			return null;
		if (forward)
			counter++;
		else
			counter--;
		while (counter < 0)
			counter += connections.size();
		counter %= connections.size();
		return connections.get(counter % connections.size());
	}

	/**
	 * Given an absolute point (pStart) and a list of EditParts, this method finds the closest
	 * EditPart (except for the one to be excluded) in the given direction.
	 * 
	 * @param	siblings	List of sibling EditParts
	 * @param	pStart		The starting point (must be in absolute coordinates) from which
	 * 						the next sibling is to be found.
	 * @param	direction	PositionConstants
	 * @param	exclude		The EditPart to be excluded from the search
	 * 
	 */
	public IGraphicalEntityPart findSibling(List<?> siblings, Point pStart, int direction, EditPart exclude) {
		IGraphicalEntityPart epCurrent;
		IGraphicalEntityPart epFinal = null;
		IFigure figure;
		Point pCurrent;
		int distance = Integer.MAX_VALUE;

		Iterator<?> iter = siblings.iterator();
		while (iter.hasNext()) {
			epCurrent = (IGraphicalEntityPart)iter.next();
			if (epCurrent == exclude || !epCurrent.isSelectable())
				continue;
			figure = epCurrent.getFigure();
			pCurrent = getNavigationPoint(figure);
			figure.translateToAbsolute(pCurrent);
			if (pStart.getPosition(pCurrent) != direction)
				continue;

			Dimension difference = pCurrent.getDifference(pStart);
			int d = Math.abs(difference.width()) + Math.abs(difference.height());
			if (d < distance) {
				distance = d;
				epFinal = epCurrent;
			}
		}
		return epFinal;
	}

	/**
	 * Figures' navigation points are used to determine their direction compared to one 
	 * another, and the distance between them.
	 *  
	 * @return	the center of the given figure
	 */
	public Point getNavigationPoint(IFigure figure) {
		return figure.getBounds().getCenter();
	}

	/**
	 * This method is invoked when the user presses the space bar.  It toggles the selection
	 * of the EditPart that currently has focus.
	 */
	protected void processSelect(KeyEvent event) {
		EditPart part = getViewer().getFocusEditPart();
		if ((event.stateMask & SWT.CONTROL) != 0
				&& part.getSelected() != EditPart.SELECTED_NONE)
			getViewer().deselect(part);
		else
			getViewer().appendSelection(part);

		getViewer().setFocus(part);
	}

	/**
	 * @return	<code>true</code> if key pressed indicates a connection traversal/selection
	 */
	boolean acceptConnection(KeyEvent event) {
		return event.character == '/'
			|| event.character == '?'
				|| event.character == '\\'
					|| event.character == '\u001c'
						|| event.character == '|';
	}

	/**
	 * This method navigates through connections based on the keys pressed.
	 */
	void navigateConnections(KeyEvent event) {
		GraphicalEditPart focus = (GraphicalEditPart) getFocusEntityPart();
		ConnectionEditPart current = null;
		GraphicalEditPart node = getCachedNode();
		if (focus instanceof ConnectionEditPart) {
			current = (ConnectionEditPart)focus;
			if (node == null
					|| (node != current.getSource() && node != current.getTarget())) {
				node = (GraphicalEditPart)current.getSource();
				counter = 0;
			}
		} else {
			node = focus;
		}

		setCachedNode(node);
		boolean forward = event.character == '/'
			|| event.character == '?';
		ConnectionEditPart next = findConnection(node, current, forward);
		navigateTo(next, event);
	}

	/**
	 * Not yet implemented.
	 */
	boolean navigateJumpSibling(KeyEvent event, int direction) {
		// TODO: Implement navigateJumpSibling() (for PGUP, PGDN, HOME and END key events)
		return false;
	}


	public boolean isRootPart(IEntityPart focusPart) {
		return focusPart == getViewer().getContents();
	}

	private EditPoint editPoint;

	public EditPoint getEditPoint() {
		if (editPoint == null)
			editPoint = new EditPoint((IEntityPart)getFocusEntityPart(), 0);
		else {
			IEntityPart focusPart = (IEntityPart)getFocusEntityPart();
			if (editPoint.focus != focusPart) {
				editPoint.focus = focusPart;
				editPoint.caret = 0;
			}
		}
		return editPoint;
	}

	public boolean navigateModel(KeyEvent event, int direction) {
		EditPoint focusPoint = getEditPoint();
		
		if (!(focusPoint.focus.getParent() instanceof IEntityPart))
			return false;

		switch (direction) {
		case NORTH:
			IEntityPart parentPart = (IEntityPart)focusPoint.focus.getParent();
			if (isRootPart(parentPart))
				return false;

			editPoint.focus = parentPart;
			break;
		case SOUTH:
			List<?> children = focusPoint.focus.getChildren();
			if (children.isEmpty())
				return false;

			editPoint.focus = (IEntityPart)children.get(0);
			break;
		case EAST:
			parentPart = (IEntityPart)focusPoint.focus.getParent();
			if (isRootPart(parentPart))
				return false;

			List<?> siblings = parentPart.getChildren();
			int index = siblings.indexOf(editPoint.focus);
			if (index < siblings.size()-1)
				editPoint.focus = findModelFirstChild((IEntityPart)siblings.get(index+1));
			else
				editPoint.focus = parentPart;
			break;
		case WEST:
			parentPart = (IEntityPart)focusPoint.focus.getParent();
			if (isRootPart(parentPart))
				return false;

			siblings = parentPart.getChildren();
			index = siblings.indexOf(editPoint.focus);
			if (index > 0)
				editPoint.focus = findModelLastChild((IEntityPart)siblings.get(index-1));
			else
				editPoint.focus = parentPart;
			break;
		}
		editPoint.caret = 0;

		navigateTo(editPoint.focus, event);
		return true;
	}
	public IEntityPart findModelFirstChild(IEntityPart parent) {
		List<?> children = parent.getChildren();
		if (children.isEmpty())
			return parent;
		return findModelFirstChild((IEntityPart)children.get(0));		
	}
	public IEntityPart findModelLastChild(IEntityPart parent) {
		List<?> children = parent.getChildren();
		if (children.isEmpty())
			return parent;
		return findModelLastChild((IEntityPart)children.get(children.size()-1));
	}

	public boolean navigateView(KeyEvent event, int direction) {
		EditPoint focusPoint = getEditPoint();
		IGEFEditorKit editorKit = (IGEFEditorKit) focusPoint.focus.getModelEntity().wGetEditorKit();
		IKeyHandler keyHandler = editorKit.getKeyHandler();
		//FIXME workaround for a bug in navigation actions
		if (focusPoint.focus instanceof ITextualEntityPart) {
			ITextualEntityPart part = (ITextualEntityPart) focusPoint.focus;
			int start = part.getSelectionStart();
			int end = part.getSelectionEnd();
			if (start != -1 && end != -1) {
				CaretUpdater.sheduleSyncUpdate(part.getViewer(), part.getModelTextEntity(), 
						direction == PositionConstants.WEST ? start : end, true);
				return true;
			} else {
				CaretUpdater.sheduleSyncUpdate(part.getViewer(), part.getModelTextEntity(), 
						part.getCaretPosition(), true);
			}
		}
		editPoint = keyHandler.findNeighbour(this, focusPoint, direction);

		if (editPoint == null)
			return navigateNextSibling(event, direction);

		navigateTo(editPoint.focus, event);
		return true;
	}

	/**
	 * Traverses to the next sibling in the given direction.
	 * 
	 * @param	event		the KeyEvent for the keys that were pressed to trigger this traversal
	 * @param	direction	PositionConstants.* indicating the direction in which to traverse
	 */
	boolean navigateNextSibling(KeyEvent event, int direction) {
		return navigateNextSibling(event, direction, getNavigationSiblings());
	}

	/**
	 * Traverses to the closest EditPart in the given list that is also in the given direction.
	 * 
	 * @param	event		the KeyEvent for the keys that were pressed to trigger this traversal
	 * @param	direction	PositionConstants.* indicating the direction in which to traverse
	 */
	boolean navigateNextSibling(KeyEvent event, int direction, List<?> list) {
		IEntityPart epStart = getFocusEntityPart();
		if (epStart instanceof ITextualEntityPart) {
			ITextualEntityPart textualEntityPart = (ITextualEntityPart) epStart;
			ITextualFigure textualFigure = textualEntityPart.getTextualFigure();
			String text = textualFigure.getText();
			int line = CaretUtils.getLineFromPosition(text, textualEntityPart.getCaretPosition());
			int lines = CaretUtils.getCaretLines(text);
			if ((direction == PositionConstants.WEST && textualEntityPart.getCaretPosition() > 0) ||
					(direction == PositionConstants.EAST && textualEntityPart.getCaretPosition() < textualEntityPart.getCaretPositions())) {
				int position = textualEntityPart.getCaretPosition() +
						(direction == PositionConstants.WEST ? -1 : 1);
				CaretUpdater.sheduleSyncUpdate(getViewer(), textualEntityPart.getModelEntity(), position, true);
				return true;
			} else if ((direction == PositionConstants.NORTH && line > 0) ||
					(direction == PositionConstants.SOUTH && line < lines)) {
				int dy = FigureUtilities.getFontMetrics(textualFigure.getFont()).getHeight() *
						(direction == PositionConstants.NORTH ? -1 : 1);
				Point location = textualFigure.getCaretBounds().getCenter().translate(0, dy);
				CaretUpdater.sheduleSyncUpdate(getViewer(), textualEntityPart.getModelEntity(), location, true);
				textualEntityPart.updateCaret(location);
				return true;
			}
		}
		if (!(epStart instanceof IGraphicalEntityPart))
			return false;
		IFigure figure = ((IGraphicalEntityPart) epStart).getFigure();
		Point pStart = getNavigationPoint(figure);
		figure.translateToAbsolute(pStart);
		EditPart next = findSibling(list, pStart, direction, epStart); // parent.findSibling(pStart, direction, epStart);
		while (next == null) {
			if (!(epStart.getParent() instanceof IGraphicalEntityPart))
				return false;

			epStart = (IGraphicalEntityPart) epStart.getParent();
			if (epStart == getViewer().getContents() || epStart.getParent() == getViewer().getContents() || epStart.getParent() == null)
				return false;

			list = epStart.getParent().getChildren();
			next = findSibling(list, pStart, direction, epStart);
		}

		// next = next.enter(pStart, direction, epStart);1+2
		navigateTo(next, event);
		return true;
	}

	/**
	 * Navigates to the source or target of the currently focused ConnectionEditPart.
	 */
	void navigateOutOfConnection(KeyEvent event) {
		GraphicalEditPart cached = getCachedNode();
		ConnectionEditPart conn = (ConnectionEditPart)getFocusEntityPart();
		if (cached != null
				&& (cached == conn.getSource()
						|| cached == conn.getTarget()))
			navigateTo(cached, event);
		else
			navigateTo(conn.getSource(), event);
	}

	/**
	 * Navigates to the given EditPart
	 * 
	 * @param	part	the EditPart to navigate to
	 * @param	event	the KeyEvent that triggered this traversal
	 */
	protected void navigateTo(EditPart part, KeyEvent event) {
		if (part == null)
			return;
		if ((event.stateMask & SWT.SHIFT) != 0)
			getViewer().appendSelection(part);
		else if (!isInsertMode())
			getViewer().select(part);
		getViewer().setFocus(part);
		getViewer().reveal(part);
	}

	/**
	 * @return	<code>true</code> if the keys pressed indicate to stop traversing/selecting
	 * 			connection
	 */
	boolean acceptLeaveConnection(KeyEvent event) {
		int key = event.keyCode;
		if (getFocusEntityPart() instanceof ConnectionEditPart)
			if ((key == SWT.ARROW_UP)
					|| (key == SWT.ARROW_RIGHT)
					|| (key == SWT.ARROW_DOWN)
					|| (key == SWT.ARROW_LEFT))
				return true;
		return false;
	}

	public boolean keyPressed(KeyEvent event) {
		//FIXME workaround (whent textual tool is enabled
		// inhibit navigation actions that use printable chars)
		if (event.keyCode == SWT.INSERT) {
			toggleInsertMode();
			return true;
		} else if (event.character == ' ' && !Tools.TEXTUAL.isActive(getViewer())) {
			processSelect(event);
			return true;
		} else if (acceptConnection(event) && !Tools.TEXTUAL.isActive(getViewer())) {
			navigateConnections(event);
			return true;
		} else if (acceptLeaveConnection(event) && !Tools.TEXTUAL.isActive(getViewer())) {
			navigateOutOfConnection(event);
			return true;
		}

		if ((event.stateMask & SWT.CTRL) != 0) {
			switch (event.keyCode) {
			case SWT.ARROW_LEFT:
				if (navigateModel(event, PositionConstants.WEST))
					return true;
				break;
			case SWT.ARROW_RIGHT:
				if (navigateModel(event, PositionConstants.EAST))
					return true;
				break;
			case SWT.ARROW_UP:
				if (navigateModel(event, PositionConstants.NORTH))
					return true;
				break;
			case SWT.ARROW_DOWN:
				if (navigateModel(event, PositionConstants.SOUTH))
					return true;
				break;
			}
		}
		switch (event.keyCode) {
		case SWT.ARROW_LEFT:
			if (navigateView(event, PositionConstants.WEST))
				return true;
			break;
		case SWT.ARROW_RIGHT:
			if (navigateView(event, PositionConstants.EAST))
				return true;
			break;
		case SWT.ARROW_UP:
			if (navigateView(event, PositionConstants.NORTH))
				return true;
			break;
		case SWT.ARROW_DOWN:
			if (navigateView(event, PositionConstants.SOUTH))
				return true;
			break;

		case SWT.HOME:
			if (navigateJumpSibling(event, PositionConstants.WEST))
				return true;
			break;
		case SWT.END:
			if (navigateJumpSibling(event, PositionConstants.EAST))
				return true;
			break;
		case SWT.PAGE_DOWN:
			if (navigateJumpSibling(event, PositionConstants.SOUTH))
				return true;
			break;
		case SWT.PAGE_UP:
			if (navigateJumpSibling(event, PositionConstants.NORTH))
				return true;
		}
		return super.keyPressed(event);
	}

}
