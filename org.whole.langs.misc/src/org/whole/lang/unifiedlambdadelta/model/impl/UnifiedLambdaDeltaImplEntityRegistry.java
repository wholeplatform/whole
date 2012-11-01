package org.whole.lang.unifiedlambdadelta.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaImplEntityRegistry extends
		AbstractEntityRegistry {
	public UnifiedLambdaDeltaImplEntityRegistry() {
		super(UnifiedLambdaDeltaEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DeclarationImpl());
		put(new DefinitionImpl());
		put(new TopImpl());
		put(new ApplicationImpl());
		put(new CastImpl());
		put(new AbstractionImpl());
		put(new AbbreviationImpl());
		put(new LocalImpl());
		put(new SortImpl());
		put(new PolarityImpl());
		put(new IndexImpl());
		put(new LevelImpl());
		put(new NameImpl());
		put(new AccessImpl());
		put(new PrefixImpl());
		put(new PostfixImpl());
	}
}
