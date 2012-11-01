package org.whole.lang.artifacts.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.artifacts.model.impl.ArtifactsImplEntityRegistry;
import org.whole.lang.artifacts.model.impl.ArtifactsStrictImplEntityRegistry;
import org.whole.lang.artifacts.model.adapters.ArtifactsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class ArtifactsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Artifacts";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.artifacts";
	}

	public String getName() {
		return "Artifacts";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return ArtifactsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return ArtifactsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new ArtifactsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new ArtifactsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new ArtifactsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return ArtifactsTemplateManager.instance();
	}
}