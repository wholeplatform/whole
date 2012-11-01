package org.whole.lang.editors.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.editors.model.impl.EditorsImplEntityRegistry;
import org.whole.lang.editors.model.impl.EditorsStrictImplEntityRegistry;
import org.whole.lang.editors.model.adapters.EditorsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class EditorsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Editors";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.editors";
	}

	public String getName() {
		return "Editors";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return EditorsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return EditorsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new EditorsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new EditorsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new EditorsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return EditorsTemplateManager.instance();
	}
}
