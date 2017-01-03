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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.e4.ui.jobs.ActionCallRunnable;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public class ActionCallHandler {

	@CanExecute
	public boolean canExecute(@Named(FUNCTION_URI_PARAMETER_ID) String functionUri,
			@Named(PREDICATE_XWL_PARAMETER_ID) String predicateXwl,
			@Optional @Named(ANALYSING_PARAMETER_ID) String analyzing,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) throws Exception {

		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		try {
			bm.wEnterScope(ts);
			defineBindings(functionUri, predicateXwl, analyzing, bm);
			return HandlersBehavior.canCallAction(bm);
		} catch (Exception e) {
			return false;
		} finally {
			ts.rollback();
			bm.wExitScope();
		}
	}

	@Execute
	public void execute(@Named(FUNCTION_URI_PARAMETER_ID) String functionUri,
			@Named(PREDICATE_XWL_PARAMETER_ID) String predicateXwl,
			@Optional @Named(ANALYSING_PARAMETER_ID) String analysing,
			@Optional @Named(DESCRIPTION_PARAMETER_ID) String label,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm,
			IEclipseContext context) throws Exception {

		ActionCallRunnable actionRunnable = new ActionCallRunnable(context, bm, label, !Boolean.parseBoolean(analysing));
		defineBindings(functionUri, predicateXwl, analysing, actionRunnable.getBindings());
		actionRunnable.asyncExec("Executing "+label+" action...");
	}

	protected void defineBindings(String functionUri, String predicateXwl, String analyzing, IBindingManager bm) throws Exception {
		IPersistenceKit persistenceKit = ReflectionFactory.getDefaultPersistenceKit();
		bm.wDefValue("analyzing", Boolean.parseBoolean(analyzing));
		bm.wDefValue("functionUri", functionUri);
		bm.wDef("predicateEntity", persistenceKit.readModel(new StringPersistenceProvider(predicateXwl)));
	}
}
