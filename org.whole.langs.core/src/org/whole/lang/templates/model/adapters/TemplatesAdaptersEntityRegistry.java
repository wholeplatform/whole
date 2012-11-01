package org.whole.lang.templates.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplatesAdaptersEntityRegistry extends AbstractEntityRegistry {
	public TemplatesAdaptersEntityRegistry() {
		super(TemplatesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TemplateManagerAdapter());
		put(new TemplatesAdapter());
		put(new TemplateFactoryAdapter());
		put(new NamesAdapter());
		put(new QualifiedNameAdapter());
		put(new SimpleNameAdapter());
		put(new TemplateAdapter());
		put(new NameAdapter());
	}
}
