package org.whole.lang.actions.reflect;

import org.whole.lang.actions.factories.ActionsDefaultEntityRegistryConfiguration;
import org.whole.lang.actions.model.adapters.ActionsAdaptersEntityRegistry;
import org.whole.lang.actions.model.impl.ActionsImplEntityRegistry;
import org.whole.lang.actions.model.impl.ActionsStrictImplEntityRegistry;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class ActionsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Actions";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.actions";
	}

	public String getName() {
		return "Actions";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return ActionsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return ActionsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new ActionsDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new ActionsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new ActionsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new ActionsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return ActionsTemplateManager.instance();
	}
}
