package org.whole.lang.scheme.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.scheme.model.impl.SchemeImplEntityRegistry;
import org.whole.lang.scheme.model.impl.SchemeStrictImplEntityRegistry;
import org.whole.lang.scheme.model.adapters.SchemeAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class SchemeLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Scheme";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.scheme";
	}

	public String getName() {
		return "Scheme";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return SchemeEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return SchemeFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new SchemeImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new SchemeStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new SchemeAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return SchemeTemplateManager.instance();
	}
}
