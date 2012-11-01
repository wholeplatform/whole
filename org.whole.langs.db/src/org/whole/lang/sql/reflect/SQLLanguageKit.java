package org.whole.lang.sql.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.sql.factories.SQLDefaultEntityRegistryConfiguration;
import org.whole.lang.sql.model.adapters.SQLAdaptersEntityRegistry;
import org.whole.lang.sql.model.impl.SQLImplEntityRegistry;
import org.whole.lang.sql.model.impl.SQLStrictImplEntityRegistry;
import org.whole.lang.sql.parsers.SQLDataTypeParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class SQLLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/SQL";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.sql";
	}

	public String getName() {
		return "SQL";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return SQLEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return SQLFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new SQLDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new SQLImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new SQLStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new SQLAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return SQLDataTypeParser.instance();
	}
	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return SQLDataTypeParser.instance();
	}


	public ITemplateManager getTemplateManager() {
		return SQLTemplateManager.instance();
	}
}
