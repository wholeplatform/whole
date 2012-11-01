package org.whole.lang.scripts.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.scripts.model.impl.ScriptsImplEntityRegistry;
import org.whole.lang.scripts.model.impl.ScriptsStrictImplEntityRegistry;
import org.whole.lang.scripts.model.adapters.ScriptsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class ScriptsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Scripts";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.scripts";
	}

	public String getName() {
		return "Scripts";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return ScriptsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return ScriptsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new ScriptsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new ScriptsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new ScriptsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return ScriptsTemplateManager.instance();
	}
}
