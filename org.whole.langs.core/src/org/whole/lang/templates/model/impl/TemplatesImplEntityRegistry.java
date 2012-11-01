package org.whole.lang.templates.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplatesImplEntityRegistry extends AbstractEntityRegistry {
	public TemplatesImplEntityRegistry() {
		super(TemplatesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TemplateManagerImpl());
		put(new TemplatesImpl());
		put(new TemplateFactoryImpl());
		put(new NamesImpl());
		put(new QualifiedNameImpl());
		put(new SimpleNameImpl());
	}
}
