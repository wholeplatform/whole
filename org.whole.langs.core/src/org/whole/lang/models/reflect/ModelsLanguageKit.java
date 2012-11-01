package org.whole.lang.models.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.models.factories.ModelsDefaultEntityRegistryConfiguration;
import org.whole.lang.models.model.impl.ModelsImplEntityRegistry;
import org.whole.lang.models.model.impl.ModelsStrictImplEntityRegistry;
import org.whole.lang.models.model.adapters.ModelsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class ModelsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Models";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.models";
	}

	public String getName() {
		return "Models";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return ModelsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return ModelsFeatureDescriptorEnum.instance;
	}

	@Override
	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new ModelsDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new ModelsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new ModelsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new ModelsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return ModelsTemplateManager.instance();
	}
}