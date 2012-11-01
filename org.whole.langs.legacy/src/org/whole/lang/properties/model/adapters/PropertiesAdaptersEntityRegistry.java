package org.whole.lang.properties.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesAdaptersEntityRegistry extends AbstractEntityRegistry {
	public PropertiesAdaptersEntityRegistry() {
		super(PropertiesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new PropertiesAdapter());
		put(new EntriesAdapter());
		put(new PropertyAdapter());
		put(new CommentAdapter());
		put(new PropertyNameAdapter());
		put(new PropertyValueAdapter());
	}
}
