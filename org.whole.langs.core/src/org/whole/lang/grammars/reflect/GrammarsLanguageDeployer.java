package org.whole.lang.grammars.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.grammars.builders.IGrammarsBuilder;
import org.whole.lang.grammars.builders.GrammarsGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.grammars.builders.GrammarsSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class GrammarsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new GrammarsLanguageKit());
		platform.addOperationFactory(GrammarsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new GrammarsGenericBuilderAdapter(
								(IGrammarsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(GrammarsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new GrammarsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(GrammarsLanguageKit.URI);
	}
}
