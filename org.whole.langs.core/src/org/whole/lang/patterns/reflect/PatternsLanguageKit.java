package org.whole.lang.patterns.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.patterns.model.impl.PatternsImplEntityRegistry;
import org.whole.lang.patterns.model.impl.PatternsStrictImplEntityRegistry;
import org.whole.lang.patterns.model.adapters.PatternsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class PatternsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "whole:org.whole.lang.patterns:PatternsModel";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.patterns";
	}

	public String getName() {
		return "Patterns";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return PatternsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return PatternsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new PatternsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new PatternsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new PatternsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return PatternsTemplateManager.instance();
	}
}
