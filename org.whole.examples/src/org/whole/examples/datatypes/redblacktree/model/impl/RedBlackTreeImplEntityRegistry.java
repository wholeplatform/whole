package org.whole.examples.datatypes.redblacktree.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RedBlackTreeImplEntityRegistry extends AbstractEntityRegistry {
	public RedBlackTreeImplEntityRegistry() {
		super(RedBlackTreeEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new RBNodeImpl());
		put(new ValueImpl());
		put(new ColorImpl());
	}
}
