package org.whole.lang.misc.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.misc.builders.IMiscBuilder;
import org.whole.lang.misc.builders.MiscGenericBuilderAdapter;
import org.whole.lang.misc.builders.MiscSpecificBuilderAdapter;
import org.whole.lang.misc.visitors.MiscDynamicCompilerVisitor;
import org.whole.lang.misc.visitors.MiscOperationVisitor;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.DynamicCompilerOperation;
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
public class MiscLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new MiscLanguageKit());
		platform.addOperationFactory(MiscLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new MiscGenericBuilderAdapter(
								(IMiscBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(MiscLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new MiscSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(MiscLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new MiscOperationVisitor();
			}
		});
		platform.addOperationFactory(MiscLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new MiscOperationVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(MiscLanguageKit.URI, ValidatorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new MiscOperationVisitor();
			}
		});
		platform.addOperationFactory(MiscLanguageKit.URI, ArtifactsGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new MiscOperationVisitor();
			}
		});
		platform.addOperationFactory(MiscLanguageKit.URI, NormalizerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new MiscOperationVisitor();
			}
		});
		platform.addOperationFactory(MiscLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new MiscDynamicCompilerVisitor();
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(MiscLanguageKit.URI);
	}
}