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
package org.whole.lang.workflows.util;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.iterators.instrumentation.DebuggerInstrumentation;
import org.whole.lang.iterators.instrumentation.DiagnosticData;
import org.whole.lang.iterators.instrumentation.DiagnosticInstrumentation;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class BreakpointUtils {
	public static Predicate<InstrumentingIterator<?>> breakpointPredicate = (ii) -> {
		IEntity selfEntity = ii.getResetEntity();
		if (selfEntity == null || !ii.hasBindings())
			return false;
		IBindingManager bm = ii.getBindings();
		boolean isEnabled = false;

		bm.wEnterScope(ii.getDebugScope());
		DebuggerInstrumentation.evaluatingPredicate = true;
		try {
			IEntity result = BehaviorUtils.apply(
					"whole:org.whole.lang.ui.views:DebugPerspectiveLibrarySemantics#breakpointEnabler", selfEntity, bm);

			isEnabled = EntityUtils.safeBooleanValue(result, false);
		} finally {
			DebuggerInstrumentation.evaluatingPredicate = false;
			bm.wExitScope();
		}
		return isEnabled;
	};

	public static Consumer<InstrumentingIterator<?>> breakpointConsumer = (ii) -> {
		if (DebuggerInstrumentation.evaluatingPredicate)
			return;

		if (ii.hasBindings() && ii.getBindings().wIsSet(IBindingManager.ECLIPSE_CONTEXT)) {
			IBindingManager bm = ii.getBindings();
			bm.wEnterScope(ii.getDebugScope());
			try {		
				E4Utils.suspendOperation(SuspensionKind.BREAK, null, ii.getSourceEntity(), bm);
			} finally {
				bm.wExitScope();
			}
		} else {
			DiagnosticData dd = DiagnosticInstrumentation.diagnosticData(ii);

			E4Utils.reportError(null, "Breakpoint without debugging service", "Unable to gather the debugging service from the execution context.\n\n"+dd.severity+": "+dd.message, null);
		}
	};
}
