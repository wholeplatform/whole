package org.whole.lang.text.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.text.model.impl.TextImplEntityRegistry;
import org.whole.lang.text.model.impl.TextStrictImplEntityRegistry;
import org.whole.lang.text.model.adapters.TextAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class TextLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Text";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.text";
	}

	public String getName() {
		return "Text";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return TextEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return TextFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new TextImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new TextStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new TextAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return TextTemplateManager.instance();
	}
}
