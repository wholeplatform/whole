package org.whole.examples.lang.imp.reflect;

import org.whole.examples.lang.imp.builders.IImpBuilder;
import org.whole.examples.lang.imp.builders.ImpGenericBuilderAdapter;
import org.whole.examples.lang.imp.builders.ImpSpecificBuilderAdapter;
import org.whole.examples.lang.imp.visitors.BytecodeGeneratorOperation;
import org.whole.examples.lang.imp.visitors.ImpBytecodeGeneratorVisitor;
import org.whole.examples.lang.imp.visitors.ImpDefUseValidatorVisitor;
import org.whole.examples.lang.imp.visitors.ImpInterpreterVisitor;
import org.whole.examples.lang.imp.visitors.ImpPrettyPrinterVisitor;
import org.whole.examples.lang.imp.visitors.ImpResolverValidatorVisitor;
import org.whole.examples.lang.imp.visitors.ImpTraversalFactory;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class ImpLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new ImpLanguageKit());
		platform.addOperationFactory(ImpLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
						return new ImpGenericBuilderAdapter((IImpBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(ImpLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
						return new ImpSpecificBuilderAdapter(strategy, entityContext);
					}
				});

		platform.addOperationFactory(ImpLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new ImpPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
		platform.addOperationFactory(ImpLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ImpInterpreterVisitor((InterpreterOperation) operation);
				else
					return null;
			}
		});
		platform.addOperationFactory(ImpLanguageKit.URI, ValidatorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return ImpTraversalFactory.instance.topDown(
						ImpTraversalFactory.instance.sequence(
								new ImpResolverValidatorVisitor((ValidatorOperation) operation),
								new ImpDefUseValidatorVisitor((ValidatorOperation) operation)
				), false);
			}
		});
		platform.addOperationFactory(ImpLanguageKit.URI, BytecodeGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new ImpBytecodeGeneratorVisitor((BytecodeGeneratorOperation) operation);
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(ImpLanguageKit.URI);
	}
}