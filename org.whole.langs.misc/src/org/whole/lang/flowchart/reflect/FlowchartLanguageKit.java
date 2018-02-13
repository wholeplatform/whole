package org.whole.lang.flowchart.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.flowchart.factories.FlowchartDefaultEntityRegistryConfiguration;
import org.whole.lang.flowchart.model.adapters.FlowchartAdaptersEntityRegistry;
import org.whole.lang.flowchart.model.impl.FlowchartImplEntityRegistry;
import org.whole.lang.flowchart.model.impl.FlowchartStrictImplEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class FlowchartLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Flowchart";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.flowchart";
	}

	public String getName() {
		return "Flowchart";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return FlowchartEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return FlowchartFeatureDescriptorEnum.instance;
	}

	@Override
	protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	new FlowchartDefaultEntityRegistryConfiguration().apply(er);
    	return er;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new FlowchartImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new FlowchartStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new FlowchartAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return FlowchartTemplateManager.instance();
	}
}
