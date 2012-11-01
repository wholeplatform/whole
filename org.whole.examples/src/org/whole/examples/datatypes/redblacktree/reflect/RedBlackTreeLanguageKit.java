package org.whole.examples.datatypes.redblacktree.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.examples.datatypes.redblacktree.model.impl.RedBlackTreeImplEntityRegistry;
import org.whole.examples.datatypes.redblacktree.model.impl.RedBlackTreeStrictImplEntityRegistry;
import org.whole.examples.datatypes.redblacktree.model.adapters.RedBlackTreeAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class RedBlackTreeLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://datatypes.examples.whole.org/RedBlackTree";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.examples.datatypes.redblacktree";
	}

	public String getName() {
		return "RedBlackTree";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return RedBlackTreeEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return RedBlackTreeFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new RedBlackTreeImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new RedBlackTreeStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new RedBlackTreeAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return RedBlackTreeTemplateManager.instance();
	}
}
