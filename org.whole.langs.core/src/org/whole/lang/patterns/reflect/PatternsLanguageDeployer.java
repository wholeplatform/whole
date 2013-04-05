package org.whole.lang.patterns.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.patterns.builders.IPatternsBuilder;
import org.whole.lang.patterns.builders.PatternsGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.patterns.builders.PatternsSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class PatternsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new PatternsLanguageKit());
		platform.addOperationFactory(PatternsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new PatternsGenericBuilderAdapter(
								(IPatternsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(PatternsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new PatternsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(PatternsLanguageKit.URI);
	}
}
