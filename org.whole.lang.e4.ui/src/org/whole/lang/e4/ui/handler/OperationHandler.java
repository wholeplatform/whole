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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.e4.ui.jobs.ISynchronizableRunnable;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class OperationHandler {

	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) throws Exception {
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		try {
			bm.wEnterScope(ts);
			IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
			return !viewer.getEditDomain().isDisabled() && isEnabled(bm);
		} catch (Exception e) {
			return false;
		} finally {
			ts.rollback();
			bm.wExitScope();
		}
	}

	@Execute
	public void execute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm,
			IEclipseContext context) throws Exception {

		createRunnable(bm, context).asyncExec("Executing "+getLabel(bm)+" operation...");
	}

	protected abstract boolean isEnabled(IBindingManager bm);
	protected abstract ISynchronizableRunnable createRunnable(IBindingManager bm, IEclipseContext context);
	protected abstract String getLabel(IBindingManager bm);
}
