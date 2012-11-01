package org.whole.lang.xsd.mapping.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.xsd.mapping.model.impl.MappingImplEntityRegistry;
import org.whole.lang.xsd.mapping.model.impl.MappingStrictImplEntityRegistry;
import org.whole.lang.xsd.mapping.model.adapters.MappingAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class MappingLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://xsd.lang.whole.org/Mapping";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.xsd.mapping";
	}

	public String getName() {
		return "Mapping";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return MappingEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return MappingFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new MappingImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new MappingStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new MappingAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return MappingTemplateManager.instance();
	}
}
