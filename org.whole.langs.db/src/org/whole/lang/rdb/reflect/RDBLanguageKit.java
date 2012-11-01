package org.whole.lang.rdb.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.rdb.model.impl.RDBImplEntityRegistry;
import org.whole.lang.rdb.model.impl.RDBStrictImplEntityRegistry;
import org.whole.lang.rdb.model.adapters.RDBAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class RDBLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/RDB";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.rdb";
	}

	public String getName() {
		return "RDB";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return RDBEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return RDBFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new RDBImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new RDBStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new RDBAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return RDBTemplateManager.instance();
	}
}
