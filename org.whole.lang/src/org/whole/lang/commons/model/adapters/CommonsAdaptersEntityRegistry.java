package org.whole.lang.commons.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CommonsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public CommonsAdaptersEntityRegistry() {
		super(CommonsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new AnyAdapter());
		put(new ResolverAdapter());
		put(new FragmentAdapter());
		put(new RootFragmentAdapter());
		put(new SameStageFragmentAdapter());
		put(new StageUpFragmentAdapter());
		put(new StageDownFragmentAdapter());
		put(new TemplateFragmentAdapter());
		put(new BaseFragmentAdapter());
		put(new PhaseAdapter());
		put(new MultiplexerAdapter());
		put(new VariableAdapter());
		put(new InlineVariableAdapter());
		put(new VarNameAdapter());
		put(new VarTypeAdapter());
		put(new QuantifierAdapter());
	}
}
