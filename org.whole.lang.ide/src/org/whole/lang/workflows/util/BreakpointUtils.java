package org.whole.lang.workflows.util;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

public class BreakpointUtils {
	public static Predicate<InstrumentingIterator<?>> breakpointPredicate = (ii) -> {
		boolean isEnabled = false;
		IBindingManager bm = ii.getBindings();
		IEntity sourceEntity = ii.getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = BindingManagerFactory.instance.createNull();//Value("<No source available>");

		try {
			bm.wEnterScope();
			bm.wDef("debug#sourceEntity", sourceEntity);
			bm.wDefValue("debug#sourceCode", ii.getIterator());
			bm.wDefValue("debug#sourceCodeClassName", ii.getIterator().getClass().getSimpleName());

			IEntity result = BehaviorUtils.apply(
					"whole:org.whole.lang.ui.views:DebugPerspectiveLibrarySemantics#breakpointEnabler", bm.wGet("self"), bm);

			isEnabled = EntityUtils.safeBooleanValue(result, false);
		} finally {
			bm.wExitScope();
		}
		return isEnabled;
	};
	public static Consumer<InstrumentingIterator<?>> breakpointConsumer = (ii) -> {
		IBindingManager bm = ii.getBindings();
		IEntity sourceEntity = ii.getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = BindingManagerFactory.instance.createNull();//Value(No source available>");

		try {
			bm.wEnterScope();
			bm.wDef("debug#sourceEntity", sourceEntity);
			bm.wDefValue("debug#sourceCode", ii.getIterator());
			bm.wDefValue("debug#sourceCodeClassName", ii.getIterator().getClass().getSimpleName());
		
			E4Utils.suspendOperation(SuspensionKind.BREAK, null, sourceEntity, bm);
		} finally {
			bm.wExitScope();
		}
	};

}
