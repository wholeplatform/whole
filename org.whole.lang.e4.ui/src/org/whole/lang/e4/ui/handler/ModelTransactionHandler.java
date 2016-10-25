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
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.e4.ui.jobs.EntityEditDomainJob;
import org.whole.lang.lifecycle.RollbackException;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class ModelTransactionHandler {

	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		try {
			bm.wEnterScope(ts);
			return isEnabled(bm);
		} catch (Exception e) {
			return false;
		} finally {
			ts.rollback();
			bm.wExitScope();
		}
	}

	@Execute
	public void execute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		EntityEditDomainJob.asyncExec(getLabel(bm), viewer.getEditDomain(), (monitor) -> {
			CommandStack commandStack = viewer.getEditDomain().getCommandStack();
			ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("focusEntity"));
			ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
			try {
				bm.wEnterScope(ts);
				mtc.setLabel(getLabel(bm));
				mtc.begin();
				run(bm);
				mtc.commit();
				if (mtc.canUndo())
					commandStack.execute(mtc);
			} catch (RollbackException e) {
				//rollback done
			} catch (RuntimeException e) {
				mtc.rollbackIfNeeded();
				throw e;
			} finally {
				ts.rollback();
				bm.wExitScope();
			}
		});
	}

	public abstract boolean isEnabled(IBindingManager bm);
	public abstract void run(IBindingManager bm);
	public abstract String getLabel(IBindingManager bm);
}
