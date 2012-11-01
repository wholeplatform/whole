package org.whole.lang.math.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.math.factories.MathDefaultEntityRegistryConfiguration;
import org.whole.lang.math.model.adapters.MathAdaptersEntityRegistry;
import org.whole.lang.math.model.impl.MathImplEntityRegistry;
import org.whole.lang.math.model.impl.MathStrictImplEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class MathLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Math";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.math";
	}

	public String getName() {
		return "Math";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return MathEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return MathFeatureDescriptorEnum.instance;
	}

	@Override
	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new MathDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new MathImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new MathStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new MathAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return MathTemplateManager.instance();
	}
}
