package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DBCFGAdaptersEntityRegistry extends AbstractEntityRegistry {
	public DBCFGAdaptersEntityRegistry() {
		super(DBCFGEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DBConfigurationAdapter());
		put(new JDBCDriversAdapter());
		put(new JDBCDriverAdapter());
		put(new FilesAdapter());
		put(new DataSourcesAdapter());
		put(new DataSourceAdapter());
		put(new IndexAdapter());
		put(new DialectAdapter());
		put(new UrlAdapter());
		put(new ServerNameAdapter());
		put(new PortNumberAdapter());
		put(new DatabaseNameAdapter());
		put(new DatabaseSchemaAdapter());
		put(new UserNameAdapter());
		put(new PasswordAdapter());
		put(new DriverNameAdapter());
		put(new ClassNameAdapter());
		put(new FilePathAdapter());
	}
}
