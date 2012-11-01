package org.whole.lang.frames.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.frames.factories.FramesDefaultEntityRegistryConfiguration;
import org.whole.lang.frames.model.adapters.FramesAdaptersEntityRegistry;
import org.whole.lang.frames.model.impl.FramesImplEntityRegistry;
import org.whole.lang.frames.model.impl.FramesStrictImplEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class FramesLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Frames";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.frames";
	}

	public String getName() {
		return "Frames";
	}

	public String getVersion() {
		return "1.0.0";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return FramesEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return FramesFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new FramesDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new FramesImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new FramesStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new FramesAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return FramesTemplateManager.instance();
	}
}
