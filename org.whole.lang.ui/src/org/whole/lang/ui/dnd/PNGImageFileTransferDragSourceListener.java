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

import java.io.File;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editpolicies.FitToMemoryStrategy;
import org.whole.lang.ui.editpolicies.WholeNonResizableEditPolicy;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class PNGImageFileTransferDragSourceListener extends AbstractFileTransferDragSourceListener {
	public PNGImageFileTransferDragSourceListener(EditPartViewer viewer) {
		super(viewer);
	}

	protected File createFile(IEntityPart entityPart) throws Exception {
		Image image = WholeNonResizableEditPolicy.createFeedbackImage(
				(IGraphicalEntityPart) entityPart, 255, false, FitToMemoryStrategy.instance());
		ImageData imageData = image.getImageData();
		String fileName = ClipboardUtils.DEFAULT_OUTPUT_FILENAME;
		if (getViewer() instanceof IEntityPartViewer) {
			IBindingManager bm = ((IEntityPartViewer) getViewer()).getContextBindings();
			if (bm.wIsSet("fileName"))
				fileName = bm.wStringValue("fileName");
		}
		File file = ClipboardUtils.createTempImageFile(fileName, imageData, ClipboardUtils.DEFAULT_OUTPUT_DPI);
		image.dispose();
		return file;
	}
}
