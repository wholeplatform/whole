package org.whole.lang.scheme.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.scheme.builders.ISchemeBuilder;
import org.whole.lang.scheme.builders.SchemeGenericBuilderAdapter;
import org.whole.lang.scheme.builders.SchemeSpecificBuilderAdapter;
import org.whole.lang.scheme.ui.SchemeTextualEditorKit;
import org.whole.lang.scheme.visitors.SchemeInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class SchemeLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new SchemeLanguageKit());
		platform.addOperationFactory(SchemeLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new SchemeGenericBuilderAdapter(
								(ISchemeBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(SchemeLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new SchemeSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(SchemeLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SchemeInterpreterVisitor((InterpreterOperation) operation);
				else
					return null;
			}
		});
		platform.addEditorKit(SchemeTextualEditorKit.ID);
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(SchemeLanguageKit.URI);
	}
}