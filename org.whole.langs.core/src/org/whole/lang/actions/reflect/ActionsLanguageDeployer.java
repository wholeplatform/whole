package org.whole.lang.actions.reflect;

import org.whole.lang.actions.builders.ActionsGenericBuilderAdapter;
import org.whole.lang.actions.builders.ActionsSpecificBuilderAdapter;
import org.whole.lang.actions.builders.IActionsBuilder;
import org.whole.lang.actions.visitors.ActionsDynamicCompilerVisitor;
import org.whole.lang.actions.visitors.ActionsInterpreterVisitor;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class ActionsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new ActionsLanguageKit());
		platform.addOperationFactory(ActionsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ActionsGenericBuilderAdapter(
								(IActionsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(ActionsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ActionsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(ActionsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ActionsInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(ActionsLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ActionsDynamicCompilerVisitor();
				else
					return null;
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(ActionsLanguageKit.URI);
	}
}
