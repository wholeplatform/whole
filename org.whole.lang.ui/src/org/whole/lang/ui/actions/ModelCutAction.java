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

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.requests.CommandFactory;
import org.whole.lang.ui.requests.TextualRequest;
import org.whole.lang.ui.util.ClipboardUtils;

/**
 * @author Enrico Persiani
 */
public class ModelCutAction extends AbstractClipboardAction {

	public ModelCutAction(IWorkbenchPart part) {
		super(part);

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
		setId(ActionFactory.CUT.getId());
		setText("Cut");
	}

	@Override
	public void run() {
		ActionRegistry actionRegistry = (ActionRegistry) getWorkbenchPart().getAdapter(ActionRegistry.class);
		AbstractClipboardAction copyAction = (AbstractClipboardAction) actionRegistry.getAction(ActionFactory.COPY.getId());

		// copy to clipboard
		copyAction.run();

		// execute delete
		List<IEntityPart> selectedEntityParts = getSelectedEntityParts();
		CompoundCommand cutCommand = new CompoundCommand();
		if (ClipboardUtils.hasTextSeletion(getViewer()))
			cutCommand.add(selectedEntityParts.get(0).getCommand(TextualRequest.createDeleteRequest()));
		else
			for (IEntityPart entityPart : selectedEntityParts)
				cutCommand.add(CommandFactory.createDeleteCommand(Collections.singletonList(entityPart)));

		if (cutCommand != null) {
			cutCommand.setLabel(getText());
			execute(cutCommand);
		}
	}
}
