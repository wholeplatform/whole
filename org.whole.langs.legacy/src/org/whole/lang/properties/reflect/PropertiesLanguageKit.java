package org.whole.lang.properties.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.properties.model.impl.PropertiesImplEntityRegistry;
import org.whole.lang.properties.model.impl.PropertiesStrictImplEntityRegistry;
import org.whole.lang.properties.model.adapters.PropertiesAdaptersEntityRegistry;
import org.whole.lang.properties.parsers.PropertiesDataTypePersistenceParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class PropertiesLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Properties";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.properties";
	}

	public String getName() {
		return "Properties";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return PropertiesEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return PropertiesFeatureDescriptorEnum.instance;
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return PropertiesDataTypePersistenceParser.instance();
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new PropertiesImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new PropertiesStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new PropertiesAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return PropertiesTemplateManager.instance();
	}
}
