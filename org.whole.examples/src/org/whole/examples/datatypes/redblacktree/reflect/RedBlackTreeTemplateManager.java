package org.whole.examples.datatypes.redblacktree.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.examples.datatypes.RedBlackTreeExample;
import org.whole.examples.datatypes.redblacktree.model.RBNode;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class RedBlackTreeTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final RedBlackTreeTemplateManager instance = new RedBlackTreeTemplateManager();
	}

	public static RedBlackTreeTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private RedBlackTreeTemplateManager() {
		put("empty", new AbstractTemplateFactory<RBNode>() {
			public RBNode create() {
				return GenericEntityFactory.instance
						.create(RedBlackTreeEntityDescriptorEnum.RBNode);
			}
		});
		put("balanced example", new RedBlackTreeExample());
	}
}
