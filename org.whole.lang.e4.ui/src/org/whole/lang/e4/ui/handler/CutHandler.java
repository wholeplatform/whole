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
package org.whole.lang.e4.ui.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.requests.TextualRequest;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class CutHandler extends RedirectableModelTransactionHandler {
	@Override
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		try {			
			if (bm.wIsSet("viewer") && ClipboardUtils.hasTextSeletion((IEntityPartViewer) bm.wGetValue("viewer"))) {
				return true;
			}
			return super.canExecute(bm);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Execute
	public void execute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		if (bm.wIsSet("viewer") && ClipboardUtils.hasTextSeletion((IEntityPartViewer) bm.wGetValue("viewer"))) {
			HandlersBehavior.copy(bm);

			IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
			IEntity focusEntity = bm.wGet("focusEntity");
			ITextualEntityPart focusPart = (ITextualEntityPart) viewer.getEditPartRegistry().get(focusEntity);

			Command command = focusPart.getCommand(TextualRequest.createDeleteRequest());
			command.setLabel(getLabel(bm)+" text");

			CommandStack commandStack = viewer.getEditDomain().getCommandStack();
			commandStack.execute(command);

			return;
		}
		super.execute(bm);
	}

	public boolean isEnabled(IBindingManager bm) {
		return HandlersBehavior.canCut(bm);
	}
	public void run(IBindingManager bm) {
		HandlersBehavior.cut(bm);
	}
	public String getLabel(IBindingManager bm) {
		return "cut";
	}
	protected void performActionRedirection(IActionRedirection actionRedirection) {
		actionRedirection.performCut();
	}
}
