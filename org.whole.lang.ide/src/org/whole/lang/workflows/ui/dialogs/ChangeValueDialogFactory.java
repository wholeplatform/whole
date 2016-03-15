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
package org.whole.lang.workflows.ui.dialogs;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.dialogs.DisabledImportAsModelDialogFactory;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.workflows.model.Assign;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.ui.dialogs.ITaskDialogFactory;

/**
 * @author Enrico Persiani
 */
public class ChangeValueDialogFactory implements ITaskDialogFactory {
	private static class SingletonHolder {
		private static final ChangeValueDialogFactory instance = new ChangeValueDialogFactory();
	}
	public static ChangeValueDialogFactory instance() {
		return SingletonHolder.instance;
	}
	private ChangeValueDialogFactory() {
	}
	public Dialog createDialog(Shell shell, String title, String message, Assignments assignments, IBindingManager bindings) {
		Assign assign = (Assign) assignments.wGet(0);
		Expression expression = assign.getExpression();
		IEntity entity = BehaviorUtils.evaluate(expression, 0, bindings);
		assign.wSet(expression, entity);

		IEclipseContext params = EclipseContextFactory.create();
		params.set("dialogTitle", title);
		params.set("dialogMessage", message);
		params.set("dialogEntity", entity);
		IEclipseContext context = (IEclipseContext) bindings.wGetValue("eclipseContext");
		IImportAsModelDialogFactory factory = ContextInjectionFactory.make(DisabledImportAsModelDialogFactory.class, context);
		params.set(IImportAsModelDialogFactory.class, factory);
		return ContextInjectionFactory.make(ChangeValueDialog.class, context, params);
	}
}
