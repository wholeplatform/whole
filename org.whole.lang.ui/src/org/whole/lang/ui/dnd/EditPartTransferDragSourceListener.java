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
package org.whole.lang.ui.dnd;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editpolicies.FitToScreenStrategy;
import org.whole.lang.ui.editpolicies.WholeNonResizableEditPolicy;
import org.whole.lang.ui.editpolicies.WholeNonResizableEditPolicy.FeedbackImageFigure;
import org.whole.lang.ui.util.ClipboardUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class EditPartTransferDragSourceListener extends AbstractSelectionTransferDragSourceListener {
	protected List<Object> modelSelection;
	protected Image dragSourceImage;

	public EditPartTransferDragSourceListener(EditPartViewer viewer) {
		super(viewer, EditPartsTransfer.instance());
	}

	public void dragSetData(DragSourceEvent event) {
		event.data = getSelectedEditParts();
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		EditPartViewer viewer = getViewer();
		List<EditPart> selectedEditParts = ClipboardUtils.getSelectedEditParts(viewer);

		if (selectedEditParts.isEmpty())
			event.doit = false;
		else
			event.image = dragSourceImage = WholeNonResizableEditPolicy.createFeedbackImage(
					(IGraphicalEntityPart) selectedEditParts.get(0), FeedbackImageFigure.ALPHA, true, FitToScreenStrategy.instance());

		storeSelection(selectedEditParts);

		// this is an hack to allow drop enablement calculations
		// see the selected entities before the final drop event
		EditPartsTransfer.instance().setObject(getSelectedEditParts());
	}
	@Override
	public void dragFinished(DragSourceEvent event) {
		restoreSelection();

		if (dragSourceImage != null)
			dragSourceImage.dispose();
	}
}
