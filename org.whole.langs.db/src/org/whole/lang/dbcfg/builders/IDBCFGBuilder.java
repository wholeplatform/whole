package org.whole.lang.dbcfg.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.dbcfg.model.DialectEnum;

/** 
 * @generator Whole
 */
public interface IDBCFGBuilder extends IBuilder {
	public void visit();

	public void password();

	public void userName();

	public void databaseSchema();

	public void databaseName();

	public void portNumber();

	public void serverName();

	public void url();

	public void dialect();

	public void files();

	public void driverClassName();

	public void driverName();

	public void dataSourceIndex();

	public void dataSources();

	public void drivers();

	public void DBConfiguration();

	public void DBConfiguration_();

	public void _DBConfiguration();

	public void JDBCDrivers();

	public void JDBCDrivers_();

	public void JDBCDrivers_(int initialCapacity);

	public void _JDBCDrivers();

	public void JDBCDriver();

	public void JDBCDriver_();

	public void _JDBCDriver();

	public void Files();

	public void Files_();

	public void Files_(int initialCapacity);

	public void _Files();

	public void DataSources();

	public void DataSources_();

	public void DataSources_(int initialCapacity);

	public void _DataSources();

	public void DataSource();

	public void DataSource_();

	public void _DataSource();

	public void Index();

	public void Index(int value);

	public void Dialect();

	public void Dialect(DialectEnum.Value value);

	public void Dialect(String value);

	public void Url();

	public void Url(String value);

	public void ServerName();

	public void ServerName(String value);

	public void PortNumber();

	public void PortNumber(int value);

	public void DatabaseName();

	public void DatabaseName(String value);

	public void DatabaseSchema();

	public void DatabaseSchema(String value);

	public void UserName();

	public void UserName(String value);

	public void Password();

	public void Password(String value);

	public void DriverName();

	public void DriverName(String value);

	public void ClassName();

	public void ClassName(String value);

	public void FilePath();

	public void FilePath(String value);
}
