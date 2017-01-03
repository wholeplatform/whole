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

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class PerformHandler  {

	@CanExecute
	public boolean canExecute(@Named(BEHAVIOR_XWL_PARAMETER_ID) String behaviorXwl,
			@Named(PREDICATE_XWL_PARAMETER_ID) String predicateXwl,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) throws Exception {
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		try {
			bm.wEnterScope(ts);
			defineBindings(behaviorXwl, predicateXwl, bm);
			return HandlersBehavior.canPerform(bm);
		} catch (Exception e) {
			return false;
		} finally {
			ts.rollback();
			bm.wExitScope();
		}
	}

	@Execute
	public void execute(@Named(BEHAVIOR_XWL_PARAMETER_ID) String behaviorXwl,
			@Named(PREDICATE_XWL_PARAMETER_ID) String predicateXwl,
			@Optional @Named(DESCRIPTION_PARAMETER_ID) String label,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm, IEntityPartViewer viewer) throws Exception {
		ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("focusEntity"), label);
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		try {
			bm.wEnterScope(ts);
			defineBindings(behaviorXwl, predicateXwl, bm);

			mtc.begin();
			HandlersBehavior.perform(bm);
			mtc.commit();
			if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		} finally {
			ts.rollback();
			bm.wExitScope();
		}
	}

	protected void defineBindings(String behaviorXwl, String predicateXwl, IBindingManager bm) throws Exception {
		IPersistenceKit persistenceKit = ReflectionFactory.getDefaultPersistenceKit();
		bm.wDef("behaviorEntity", persistenceKit.readModel(new StringPersistenceProvider(behaviorXwl)));
		bm.wDef("predicateEntity", persistenceKit.readModel(new StringPersistenceProvider(predicateXwl)));
	}
}
