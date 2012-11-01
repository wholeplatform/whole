package org.whole.lang.misc.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.misc.model.impl.MiscImplEntityRegistry;
import org.whole.lang.misc.model.impl.MiscStrictImplEntityRegistry;
import org.whole.lang.misc.model.adapters.MiscAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class MiscLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Misc";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.misc";
	}

	public String getName() {
		return "Misc";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return MiscEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return MiscFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new MiscImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new MiscStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new MiscAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return MiscTemplateManager.instance();
	}
}