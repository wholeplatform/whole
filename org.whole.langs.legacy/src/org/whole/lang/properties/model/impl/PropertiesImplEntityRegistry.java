package org.whole.lang.properties.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesImplEntityRegistry extends AbstractEntityRegistry {
	public PropertiesImplEntityRegistry() {
		super(PropertiesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new PropertiesImpl());
		put(new EntriesImpl());
		put(new PropertyImpl());
		put(new CommentImpl());
		put(new PropertyNameImpl());
		put(new PropertyValueImpl());
	}
}
