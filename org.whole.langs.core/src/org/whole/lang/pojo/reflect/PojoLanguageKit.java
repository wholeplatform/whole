package org.whole.lang.pojo.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.pojo.model.impl.PojoImplEntityRegistry;
import org.whole.lang.pojo.model.impl.PojoStrictImplEntityRegistry;
import org.whole.lang.pojo.model.adapters.PojoAdaptersEntityRegistry;
import org.whole.lang.pojo.parsers.PojoDataTypePresentationParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class PojoLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Pojo";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.pojo";
	}

	public String getName() {
		return "Pojo";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return PojoEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return PojoFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new PojoImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new PojoStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new PojoAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return PojoDataTypePresentationParser.instance();
	}
	
	public ITemplateManager getTemplateManager() {
		return PojoTemplateManager.instance();
	}
}
