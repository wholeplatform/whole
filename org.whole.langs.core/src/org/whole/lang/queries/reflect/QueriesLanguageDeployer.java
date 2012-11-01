package org.whole.lang.queries.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.queries.builders.IQueriesBuilder;
import org.whole.lang.queries.builders.QueriesGenericBuilderAdapter;
import org.whole.lang.queries.builders.QueriesSpecificBuilderAdapter;
import org.whole.lang.queries.visitors.QueriesDynamicCompilerVisitor;
import org.whole.lang.queries.visitors.QueriesInterpreterVisitor;
import org.whole.lang.queries.visitors.QueriesPrettyPrinterVisitor;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class QueriesLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new QueriesLanguageKit());
		platform.addOperationFactory(QueriesLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new QueriesGenericBuilderAdapter(
								(IQueriesBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(QueriesLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new QueriesSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(QueriesLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new QueriesInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(QueriesLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new QueriesDynamicCompilerVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(QueriesLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new QueriesPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(QueriesLanguageKit.URI);
	}
}