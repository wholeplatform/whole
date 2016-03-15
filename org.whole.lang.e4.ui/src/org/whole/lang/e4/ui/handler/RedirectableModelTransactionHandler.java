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
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.actions.NullActionRedirection;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class RedirectableModelTransactionHandler extends ModelTransactionHandler {

	@Override
	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		try {
			return getActionRedirection(bm).isActive() ? true : super.canExecute(bm);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Execute
	public void execute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		IActionRedirection actionRedirection = getActionRedirection(bm);
		if (actionRedirection.isActive())
			performActionRedirection(actionRedirection);
		else
			super.execute(bm);
	}

	protected IActionRedirection getActionRedirection(IBindingManager bm) {
		if (!bm.wIsSet("focusEntity"))
			return NullActionRedirection.instance();

		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntityPart entityPart = viewer.getEditPartRegistry().get(bm.wGet("focusEntity"));
		IActionRedirection actionRedirection = (IActionRedirection) entityPart.getAdapter(IActionRedirection.class);
		return actionRedirection != null ? actionRedirection : NullActionRedirection.instance();
	}

	protected abstract void performActionRedirection(IActionRedirection actionRedirection);
}
