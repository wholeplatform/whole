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


import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ClipboardUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class ModelCopyAction extends AbstractClipboardAction {

	public ModelCopyAction(IWorkbenchPart part) {
		super(part);

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setId(ActionFactory.COPY.getId());
		setText("Copy");
	}

	public void run() {
		List<IEntityPart> selectedEntityParts = getSelectedEntityParts();

		GraphicalViewer viewer = getViewer();
		if (ClipboardUtils.hasTextSeletion(viewer))
			Clipboard.instance().setTextContents(ClipboardUtils.getTextSelection(viewer));
		else
			Clipboard.instance().setEntityContents(selectedEntityParts);

		// force selection state change for clipboard actions enablement calculation
		viewer.setSelection(viewer.getSelection());
	}
}
