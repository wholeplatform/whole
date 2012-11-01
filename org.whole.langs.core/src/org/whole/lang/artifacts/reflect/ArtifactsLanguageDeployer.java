package org.whole.lang.artifacts.reflect;

import org.whole.lang.artifacts.builders.ArtifactsGenericBuilderAdapter;
import org.whole.lang.artifacts.builders.ArtifactsSpecificBuilderAdapter;
import org.whole.lang.artifacts.builders.IArtifactsBuilder;
import org.whole.lang.artifacts.visitors.ArtifactsInterpreterVisitor;
import org.whole.lang.artifacts.visitors.ResourceArtifactsGeneratorVisitor;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class ArtifactsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new ArtifactsLanguageKit());
		platform.addOperationFactory(ArtifactsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ArtifactsGenericBuilderAdapter(
								(IArtifactsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(ArtifactsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new ArtifactsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(ArtifactsLanguageKit.URI,
				ArtifactsGeneratorOperation.ID, new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
					return new ResourceArtifactsGeneratorVisitor();
			}
		});
		platform.addOperationFactory(ArtifactsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ArtifactsInterpreterVisitor();
				else
					return null;
			}
		});

	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(ArtifactsLanguageKit.URI);
	}
}
