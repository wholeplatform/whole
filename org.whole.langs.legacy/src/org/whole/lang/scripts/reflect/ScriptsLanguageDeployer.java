package org.whole.lang.scripts.reflect;

import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.scripts.builders.IScriptsBuilder;
import org.whole.lang.scripts.builders.ScriptsGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.scripts.builders.ScriptsSpecificBuilderAdapter;
import org.whole.lang.scripts.visitors.ScriptsInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class ScriptsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new ScriptsLanguageKit());
		platform.addOperationFactory(ScriptsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ScriptsGenericBuilderAdapter(
								(IScriptsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(ScriptsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ScriptsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(ScriptsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ScriptsInterpreterVisitor();
				else
					return null;
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(ScriptsLanguageKit.URI);
	}
}
