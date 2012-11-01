package org.whole.lang.unifiedlambdadelta.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaAdaptersEntityRegistry extends
		AbstractEntityRegistry {
	public UnifiedLambdaDeltaAdaptersEntityRegistry() {
		super(UnifiedLambdaDeltaEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ContextAdapter());
		put(new TermAdapter());
		put(new BinderAdapter());
		put(new BinaryItemAdapter());
		put(new BinaryContextBinderAdapter());
		put(new DeclarationAdapter());
		put(new DefinitionAdapter());
		put(new TopAdapter());
		put(new BinaryTermAdapter());
		put(new ApplicationAdapter());
		put(new CastAdapter());
		put(new BinaryTermBinderAdapter());
		put(new AbstractionAdapter());
		put(new AbbreviationAdapter());
		put(new LocalAdapter());
		put(new SortAdapter());
		put(new PolarityAdapter());
		put(new IndexAdapter());
		put(new LevelAdapter());
		put(new NameAdapter());
		put(new AccessAdapter());
		put(new PrefixAdapter());
		put(new PostfixAdapter());
	}
}
