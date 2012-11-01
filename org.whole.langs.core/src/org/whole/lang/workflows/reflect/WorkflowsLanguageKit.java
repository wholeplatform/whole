package org.whole.lang.workflows.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.workflows.factories.WorkflowsDefaultEntityRegistryConfiguration;
import org.whole.lang.workflows.model.adapters.WorkflowsAdaptersEntityRegistry;
import org.whole.lang.workflows.model.impl.WorkflowsImplEntityRegistry;
import org.whole.lang.workflows.model.impl.WorkflowsStrictImplEntityRegistry;

/** 
 * @generator Whole
 */
public class WorkflowsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Workflows";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.workflows";
	}

	public String getName() {
		return "Workflows";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return WorkflowsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return WorkflowsFeatureDescriptorEnum.instance;
	}

    protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	new WorkflowsDefaultEntityRegistryConfiguration().apply(er);
    	return er;
    }

	protected IEntityRegistry createImplEntityRegistry() {
		return new WorkflowsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new WorkflowsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new WorkflowsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return WorkflowsTemplateManager.instance();
	}
}