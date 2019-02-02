/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.tests.visitors;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.ui.util.SuspensionKind;

/**
 * @author Enrico Persiani
 */
public class TestsUIInterpreterVisitor extends TestsLearningInterpreterVisitor {
	@Override
	protected void reportError(String name, RuntimeException e) {
		super.reportError(name, e);
		IBindingManager debugEnv = getBindings();
		IEclipseContext context = (IEclipseContext) debugEnv.wGetValue(IBindingManager.ECLIPSE_CONTEXT);
		if ((debugEnv.wIsSet(IBindingManager.REPORT_MODE_ENABLED) && !debugEnv.wBooleanValue(IBindingManager.REPORT_MODE_ENABLED)) ||
				(debugEnv.wIsSet(IBindingManager.DEBUG_MODE_ENABLED) && !debugEnv.wBooleanValue(IBindingManager.DEBUG_MODE_ENABLED)) ||
				(debugEnv.wIsSet(IBindingManager.BREAKPOINTS_ENABLED) && !debugEnv.wBooleanValue(IBindingManager.BREAKPOINTS_ENABLED)))
			return;
		else
			E4Utils.suspendOrReportException(context, SuspensionKind.RECOVERABLE_ERROR, "Model test error", "Error while executing "+name+" test", e, debugEnv);
	}
	@Override
	protected void reportFailure(String name, TestsException e) {
		super.reportFailure(name, e);
		IBindingManager debugEnv = getBindings();
		if ((debugEnv.wIsSet(IBindingManager.REPORT_MODE_ENABLED) && !debugEnv.wBooleanValue(IBindingManager.REPORT_MODE_ENABLED)) ||
				(debugEnv.wIsSet(IBindingManager.DEBUG_MODE_ENABLED) && !debugEnv.wBooleanValue(IBindingManager.DEBUG_MODE_ENABLED)) ||
				(debugEnv.wIsSet(IBindingManager.BREAKPOINTS_ENABLED) && !debugEnv.wBooleanValue(IBindingManager.BREAKPOINTS_ENABLED)))
			return;
		else
			E4Utils.suspendOperation(SuspensionKind.RECOVERABLE_ERROR, e, e.getSubjectStatement(), e.getBindings());
	}
}
