package org.whole.examples.datatypes.redblacktree.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RedBlackTreeAdaptersEntityRegistry extends AbstractEntityRegistry {
	public RedBlackTreeAdaptersEntityRegistry() {
		super(RedBlackTreeEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new RBNodeAdapter());
		put(new ValueAdapter());
		put(new ColorAdapter());
	}
}
