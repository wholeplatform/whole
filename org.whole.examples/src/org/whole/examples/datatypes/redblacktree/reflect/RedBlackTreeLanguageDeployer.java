package org.whole.examples.datatypes.redblacktree.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.examples.datatypes.redblacktree.builders.IRedBlackTreeBuilder;
import org.whole.examples.datatypes.redblacktree.builders.RedBlackTreeGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.examples.datatypes.redblacktree.builders.RedBlackTreeSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class RedBlackTreeLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new RedBlackTreeLanguageKit());
		platform.addOperationFactory(RedBlackTreeLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new RedBlackTreeGenericBuilderAdapter(
								(IRedBlackTreeBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(RedBlackTreeLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new RedBlackTreeSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(RedBlackTreeLanguageKit.URI);
	}
}
