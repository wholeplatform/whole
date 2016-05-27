package org.whole.lang.commons.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CommonsImplEntityRegistry extends AbstractEntityRegistry {
	public CommonsImplEntityRegistry() {
		super(CommonsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ResolverImpl());
		put(new RootFragmentImpl());
		put(new SameStageFragmentImpl());
		put(new StageUpFragmentImpl());
		put(new StageDownFragmentImpl());
		put(new TemplateFragmentImpl());
		put(new BaseFragmentImpl());
		put(new PhaseImpl());
		put(new MultiplexerImpl());
		put(new VariableImpl());
		put(new InlineVariableImpl());
		put(new VarNameImpl());
		put(new VarTypeImpl());
		put(new QuantifierImpl());
	}
}
