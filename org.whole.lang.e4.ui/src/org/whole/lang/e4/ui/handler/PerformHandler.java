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

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ModelTransactionCommand;

/**
 * @author Enrico Persiani
 */
public class PerformHandler  {

	@CanExecute
	public boolean canExecute(@Named(BEHAVIOR_XWL_PARAMETER_ID) String behaviorXwl,
			@Named(PREDICATE_XWL_PARAMETER_ID) String predicateXwl,
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) throws Exception {
		try {
			bm.wEnterScope();
			defineBindings(behaviorXwl, predicateXwl, bm);
			return HandlersBehavior.canPerform(bm);
		} catch (Exception e) {
			return false;
		} finally {
			bm.wExitScope();
		}
	}

	@Execute
	public void execute(@Named(BEHAVIOR_XWL_PARAMETER_ID) String behaviorXwl,
			@Named(PREDICATE_XWL_PARAMETER_ID) String predicateXwl,
			@Optional @Named(DESCRIPTION_PARAMETER_ID) String label,
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm, IEntityPartViewer viewer) throws Exception {
		ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("primarySelectedEntity"), label);
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		try {
			bm.wEnterScope();
			defineBindings(behaviorXwl, predicateXwl, bm);

			mtc.begin();
			HandlersBehavior.perform(bm);
			mtc.commit();
			if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		} finally {
			bm.wExitScope();
		}
	}

	protected void defineBindings(String behaviorXwl, String predicateXwl, IBindingManager bm) throws Exception {
		IPersistenceKit persistenceKit = ReflectionFactory.getDefaultPersistenceKit();
		bm.wDef("behaviorEntity", persistenceKit.readModel(new StringPersistenceProvider(behaviorXwl)));
		bm.wDef("predicateEntity", persistenceKit.readModel(new StringPersistenceProvider(predicateXwl)));
	}
}
