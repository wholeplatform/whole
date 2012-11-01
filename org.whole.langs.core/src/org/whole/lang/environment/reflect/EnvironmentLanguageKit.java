package org.whole.lang.environment.reflect;

import org.whole.lang.environment.model.adapters.EnvironmentAdaptersEntityRegistry;
import org.whole.lang.environment.model.impl.EnvironmentImplEntityRegistry;
import org.whole.lang.environment.model.impl.EnvironmentStrictImplEntityRegistry;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class EnvironmentLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Environment";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.environment";
	}

	public String getName() {
		return "Environment";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return EnvironmentEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return EnvironmentFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new EnvironmentImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new EnvironmentStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new EnvironmentAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return EnvironmentTemplateManager.instance();
	}
}
