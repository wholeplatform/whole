package org.whole.lang.firstorderlogic.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.firstorderlogic.model.impl.FirstOrderLogicImplEntityRegistry;
import org.whole.lang.firstorderlogic.model.impl.FirstOrderLogicStrictImplEntityRegistry;
import org.whole.lang.firstorderlogic.model.adapters.FirstOrderLogicAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class FirstOrderLogicLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/FirstOrderLogic";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.firstorderlogic";
	}

	public String getName() {
		return "FirstOrderLogic";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return FirstOrderLogicEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return FirstOrderLogicFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new FirstOrderLogicImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new FirstOrderLogicStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new FirstOrderLogicAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return FirstOrderLogicTemplateManager.instance();
	}
}
