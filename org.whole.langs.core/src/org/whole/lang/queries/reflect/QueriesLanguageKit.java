package org.whole.lang.queries.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.queries.factories.QueriesDefaultEntityRegistryConfiguration;
import org.whole.lang.queries.model.adapters.QueriesAdaptersEntityRegistry;
import org.whole.lang.queries.model.impl.QueriesImplEntityRegistry;
import org.whole.lang.queries.model.impl.QueriesStrictImplEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class QueriesLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Queries";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.queries";
	}

	public String getName() {
		return "Queries";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return QueriesEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return QueriesFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new QueriesDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new QueriesImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new QueriesStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new QueriesAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return QueriesTemplateManager.instance();
	}
}
