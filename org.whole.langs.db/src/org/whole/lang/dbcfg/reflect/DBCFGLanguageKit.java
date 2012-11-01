package org.whole.lang.dbcfg.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.dbcfg.model.impl.DBCFGImplEntityRegistry;
import org.whole.lang.dbcfg.model.impl.DBCFGStrictImplEntityRegistry;
import org.whole.lang.dbcfg.model.adapters.DBCFGAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class DBCFGLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/DBCFG";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.dbcfg";
	}

	public String getName() {
		return "DBCFG";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return DBCFGEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return DBCFGFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new DBCFGImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new DBCFGStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new DBCFGAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return DBCFGTemplateManager.instance();
	}
}
