package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DBCFGImplEntityRegistry extends AbstractEntityRegistry {
	public DBCFGImplEntityRegistry() {
		super(DBCFGEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DBConfigurationImpl());
		put(new JDBCDriversImpl());
		put(new JDBCDriverImpl());
		put(new FilesImpl());
		put(new DataSourcesImpl());
		put(new DataSourceImpl());
		put(new IndexImpl());
		put(new DialectImpl());
		put(new UrlImpl());
		put(new ServerNameImpl());
		put(new PortNumberImpl());
		put(new DatabaseNameImpl());
		put(new DatabaseSchemaImpl());
		put(new UserNameImpl());
		put(new PasswordImpl());
		put(new DriverNameImpl());
		put(new ClassNameImpl());
		put(new FilePathImpl());
	}
}
