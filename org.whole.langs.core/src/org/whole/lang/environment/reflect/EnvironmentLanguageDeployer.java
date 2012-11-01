package org.whole.lang.environment.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.environment.builders.EnvironmentGenericBuilderAdapter;
import org.whole.lang.environment.builders.EnvironmentSpecificBuilderAdapter;
import org.whole.lang.environment.builders.IEnvironmentBuilder;
import org.whole.lang.environment.visitors.EnvironmentPrettyPrinterVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @generator Whole
 */
public class EnvironmentLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new EnvironmentLanguageKit());
		platform.addOperationFactory(EnvironmentLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new EnvironmentGenericBuilderAdapter(
								(IEnvironmentBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(EnvironmentLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new EnvironmentSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(EnvironmentLanguageKit.URI,
				InterpreterOperation.ID, new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage != 0)
					return null;

				return new AbstractVisitor() {
					public void visit(IEntity entity) {
						setResult(EntityUtils.clone(entity));
					}
				};
			}
		});
	
		platform.addOperationFactory(EnvironmentLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new EnvironmentPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(EnvironmentLanguageKit.URI);
	}
}