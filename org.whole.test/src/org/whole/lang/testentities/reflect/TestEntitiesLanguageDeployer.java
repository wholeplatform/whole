package org.whole.lang.testentities.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.testentities.builders.ITestEntitiesBuilder;
import org.whole.lang.testentities.builders.TestEntitiesGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.testentities.builders.TestEntitiesSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class TestEntitiesLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		if (ReflectionFactory.getLanguageKitRegistry().containsResource(TestEntitiesLanguageKit.URI, false, null))
			return;

		platform.addLanguageKit(new TestEntitiesLanguageKit());
		platform.addOperationFactory(TestEntitiesLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TestEntitiesGenericBuilderAdapter(
								(ITestEntitiesBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(TestEntitiesLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TestEntitiesSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(TestEntitiesLanguageKit.URI);
	}
}
