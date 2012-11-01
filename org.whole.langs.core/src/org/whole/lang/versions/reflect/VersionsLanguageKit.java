package org.whole.lang.versions.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.versions.model.impl.VersionsImplEntityRegistry;
import org.whole.lang.versions.model.impl.VersionsStrictImplEntityRegistry;
import org.whole.lang.versions.model.adapters.VersionsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class VersionsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Versions";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.versions";
	}

	public String getName() {
		return "Versions";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return VersionsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return VersionsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new VersionsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new VersionsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new VersionsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return VersionsTemplateManager.instance();
	}
}
