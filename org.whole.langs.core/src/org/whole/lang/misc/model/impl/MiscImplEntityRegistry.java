package org.whole.lang.misc.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MiscImplEntityRegistry extends AbstractEntityRegistry {
	public MiscImplEntityRegistry() {
		super(MiscEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new MiscImpl());
	}
}
