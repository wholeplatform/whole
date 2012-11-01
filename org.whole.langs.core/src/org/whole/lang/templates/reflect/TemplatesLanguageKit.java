package org.whole.lang.templates.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.templates.model.impl.TemplatesImplEntityRegistry;
import org.whole.lang.templates.model.impl.TemplatesStrictImplEntityRegistry;
import org.whole.lang.templates.model.adapters.TemplatesAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class TemplatesLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Templates";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.templates";
	}

	public String getName() {
		return "Templates";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return TemplatesEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return TemplatesFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new TemplatesImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new TemplatesStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new TemplatesAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return TemplatesTemplateManager.instance();
	}
}
