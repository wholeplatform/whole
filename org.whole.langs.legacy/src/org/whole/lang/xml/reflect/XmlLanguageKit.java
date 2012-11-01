package org.whole.lang.xml.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.xml.factories.XmlDefaultEntityRegistryConfiguration;
import org.whole.lang.xml.model.impl.XmlImplEntityRegistry;
import org.whole.lang.xml.model.impl.XmlStrictImplEntityRegistry;
import org.whole.lang.xml.model.adapters.XmlAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class XmlLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Xml";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.xml";
	}

	public String getName() {
		return "Xml";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return XmlEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return XmlFeatureDescriptorEnum.instance;
	}

    protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	new XmlDefaultEntityRegistryConfiguration().apply(er);
    	return er;
    }

    protected IEntityRegistry createImplEntityRegistry() {
		return new XmlImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new XmlStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new XmlAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return XmlTemplateManager.instance();
	}
}