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
package org.whole.lang.ui.views;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.ui.commands.HistoryCommandStack;

/**
 * @author Enrico Persiani
 */
public class WholeEditDomain extends DefaultEditDomain {
	private CommandStack commandStack;

	public WholeEditDomain() {
		this(null);
	}
	public WholeEditDomain(IEditorPart editorPart) {
		super(editorPart);
	}

	@Override
	protected void setEditorPart(IEditorPart editorPart) {
		super.setEditorPart(editorPart);
		if (commandStack != null) {
			commandStack.dispose();
			commandStack = null;
		}
	}

	@Override
	public CommandStack getCommandStack() {
		if (commandStack == null)
			commandStack = getEditorPart() == null ? super.getCommandStack() : new HistoryCommandStack(this);

		return commandStack;
	}

	@Override
	public void addViewer(EditPartViewer viewer) {
		super.addViewer(viewer);

		// disables system specific drag detect strategy
		viewer.getControl().setDragDetect(false);
	}

	@Override
	public void mouseDrag(MouseEvent mouseEvent, EditPartViewer viewer) {
		// performs whole specific drag detect strategy
		if (isDragDetect(mouseEvent, viewer)) {
			abortDragTracker(viewer);
			mouseEvent.button = 1;
			mouseEvent.count = 1;
			viewer.getControl().dragDetect(mouseEvent);
		} else
			super.mouseDrag(mouseEvent, viewer);
	}

	protected boolean isDragDetect(MouseEvent mouseEvent, EditPartViewer viewer) {
		//FIXME workaround for MacOS X ?
		if (!(viewer.getControl() instanceof FigureCanvas))
			return false;

		FigureCanvas figureCanvas = (FigureCanvas) viewer.getControl();
		return !figureCanvas.getClientArea().contains(mouseEvent.x, mouseEvent.y);
	}

	protected void abortDragTracker(EditPartViewer viewer) {
		// hack: send a synthetic ESC key-press to interrupt GEF drag 
		Event event = new Event();
		event.display = viewer.getControl().getDisplay();
		event.widget = viewer.getControl();
		event.character = 27;
		event.keyCode = SWT.ESC;
		event.stateMask = SWT.NONE;
		event.doit = true;
		getActiveTool().keyDown(new KeyEvent(event),viewer);
	}
}
