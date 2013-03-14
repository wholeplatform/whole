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
package org.whole.lang.e4.ui.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.ui.actions.ModelFindAction;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class FindReplaceHandler {

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		return HandlersBehavior.isValidEntityPartSelection(bm, false);
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		ModelFindAction.findReplaceDialogInstance.setSelectedEntity(EntityUtils.clone(bm.wGet("primarySelectedEntity")));
		ModelFindAction.findReplaceDialogInstance.close();
		ModelFindAction.findReplaceDialogInstance.setParentShell(shell);
		ModelFindAction.findReplaceDialogInstance.open();
	}
}
