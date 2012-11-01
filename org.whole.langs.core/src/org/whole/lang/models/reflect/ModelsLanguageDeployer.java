package org.whole.lang.models.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.builders.ModelsGenericBuilderAdapter;
import org.whole.lang.models.builders.ModelsSpecificBuilderAdapter;
import org.whole.lang.models.visitors.ModelsInterpreterVisitor;
import org.whole.lang.models.visitors.ModelsNormalizerVisitor;
import org.whole.lang.models.visitors.ModelsPrettyPrinterVisitor;
import org.whole.lang.models.visitors.ModelsValidatorVisitor;
import org.whole.lang.models.visitors.TeXGeneratorVisitor;
import org.whole.lang.operations.ExportTexOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class ModelsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new ModelsLanguageKit());
		platform.addOperationFactory(ModelsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ModelsGenericBuilderAdapter(
								(IModelsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(ModelsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ModelsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(ModelsLanguageKit.URI, ExportTexOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new TeXGeneratorVisitor((ExportTexOperation) operation);
			}
		});
		platform.addOperationFactory(ModelsLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new ModelsPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
		platform.addOperationFactory(ModelsLanguageKit.URI, ValidatorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new ModelsValidatorVisitor();
			}
		});
		platform.addOperationFactory(ModelsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ModelsInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(ModelsLanguageKit.URI, NormalizerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new ModelsNormalizerVisitor();
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(ModelsLanguageKit.URI);
	}
}