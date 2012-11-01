package org.whole.lang.frames.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.frames.builders.FramesGenericBuilderAdapter;
import org.whole.lang.frames.builders.FramesSpecificBuilderAdapter;
import org.whole.lang.frames.builders.IFramesBuilder;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;

/** 
 * @generator Whole
 */
public class FramesLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new FramesLanguageKit());
		platform.addOperationFactory(FramesLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new FramesGenericBuilderAdapter(
								(IFramesBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(FramesLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new FramesSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(FramesLanguageKit.URI);
	}
}
