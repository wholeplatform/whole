/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.viewers;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;

/**
 * @author Enrico Persiani
 */
public class E4EditDomain extends EditDomain {
	public void addViewer(E4GraphicalViewer viewer) {
		super.addViewer(viewer);

		// configures a new command stack
		setCommandStack(new E4HistoryCommandStack(viewer));

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
