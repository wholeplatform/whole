package org.whole.lang.testevents.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testevents.builders.ITestEventsBuilder;
import org.whole.lang.testevents.builders.TestEventsGenericBuilderAdapter;
import org.whole.lang.testevents.builders.TestEventsSpecificBuilderAdapter;

/** 
 * @generator Whole
 */
public class TestEventsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		if (ReflectionFactory.getLanguageKitRegistry().containsResource(TestEventsLanguageKit.URI, false, null))
			return;

		platform.addLanguageKit(new TestEventsLanguageKit());
		platform.addOperationFactory(TestEventsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TestEventsGenericBuilderAdapter(
								(ITestEventsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(TestEventsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TestEventsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(TestEventsLanguageKit.URI);
	}
}
