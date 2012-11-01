package org.whole.lang.types.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.types.model.impl.TypesImplEntityRegistry;
import org.whole.lang.types.model.impl.TypesStrictImplEntityRegistry;
import org.whole.lang.types.model.adapters.TypesAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class TypesLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Types";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.types";
	}

	public String getName() {
		return "Types";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return TypesEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return TypesFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new TypesImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new TypesStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new TypesAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return TypesTemplateManager.instance();
	}
}
