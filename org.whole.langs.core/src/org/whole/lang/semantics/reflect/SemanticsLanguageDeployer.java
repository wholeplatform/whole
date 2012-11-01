package org.whole.lang.semantics.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.semantics.builders.ISemanticsBuilder;
import org.whole.lang.semantics.builders.SemanticsGenericBuilderAdapter;
import org.whole.lang.semantics.builders.SemanticsSpecificBuilderAdapter;
import org.whole.lang.semantics.visitors.SemanticsDynamicCompilerVisitor;
import org.whole.lang.semantics.visitors.SemanticsInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class SemanticsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new SemanticsLanguageKit());
		platform.addOperationFactory(SemanticsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new SemanticsGenericBuilderAdapter(
								(ISemanticsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(SemanticsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new SemanticsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(SemanticsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SemanticsInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(SemanticsLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SemanticsDynamicCompilerVisitor();
				else
					return null;
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(SemanticsLanguageKit.URI);
	}
}
