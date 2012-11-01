package org.whole.lang.misc.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MiscAdaptersEntityRegistry extends AbstractEntityRegistry {
	public MiscAdaptersEntityRegistry() {
		super(MiscEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new MiscAdapter());
		put(new AnyAdapter());
	}
}
