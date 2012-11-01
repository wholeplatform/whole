package org.whole.lang.unifiedlambdadelta.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.unifiedlambdadelta.builders.IUnifiedLambdaDeltaBuilder;
import org.whole.lang.unifiedlambdadelta.builders.UnifiedLambdaDeltaGenericBuilderAdapter;
import org.whole.lang.unifiedlambdadelta.builders.UnifiedLambdaDeltaSpecificBuilderAdapter;
import org.whole.lang.unifiedlambdadelta.ui.UnifiedLambdaDeltaTextualEditorKit;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new UnifiedLambdaDeltaLanguageKit());
		platform.addOperationFactory(UnifiedLambdaDeltaLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new UnifiedLambdaDeltaGenericBuilderAdapter(
								(IUnifiedLambdaDeltaBuilder) strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(UnifiedLambdaDeltaLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new UnifiedLambdaDeltaSpecificBuilderAdapter(
								strategy, entityContext);
					}
				});
		platform.addEditorKit(UnifiedLambdaDeltaTextualEditorKit.ID);
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(UnifiedLambdaDeltaLanguageKit.URI);
	}
}