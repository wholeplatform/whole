package org.whole.examples.lang.imp.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.examples.lang.imp.model.impl.ImpImplEntityRegistry;
import org.whole.examples.lang.imp.model.impl.ImpStrictImplEntityRegistry;
import org.whole.examples.lang.imp.model.adapters.ImpAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class ImpLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.examples.whole.org/Imp";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.examples.lang.imp";
	}

	public String getName() {
		return "Imp";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return ImpEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return ImpFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new ImpImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new ImpStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new ImpAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return ImpTemplateManager.instance();
	}
}
