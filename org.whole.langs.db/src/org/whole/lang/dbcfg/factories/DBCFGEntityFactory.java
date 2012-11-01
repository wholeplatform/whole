package org.whole.lang.dbcfg.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DBCFGEntityFactory extends GenericEntityFactory {
	public static final DBCFGEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static DBCFGEntityFactory instance(IEntityRegistryProvider provider) {
		return new DBCFGEntityFactory(provider);
	}

	protected DBCFGEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public DBConfiguration createDBConfiguration() {
		return create(DBCFGEntityDescriptorEnum.DBConfiguration);
	}

	public DBConfiguration createDBConfiguration(JDBCDrivers drivers,
			DataSources dataSources, Index dataSourceIndex) {
		return create(DBCFGEntityDescriptorEnum.DBConfiguration, drivers,
				dataSources, dataSourceIndex);
	}

	public IEntityBuilder<DBConfiguration> buildDBConfiguration() {
		return new EntityBuilder<DBConfiguration>(
				create(DBCFGEntityDescriptorEnum.DBConfiguration));
	}

	public JDBCDrivers createJDBCDrivers() {
		return create(DBCFGEntityDescriptorEnum.JDBCDrivers);
	}

	public JDBCDrivers createJDBCDrivers(JDBCDriver... entities) {
		return create(DBCFGEntityDescriptorEnum.JDBCDrivers,
				(IEntity[]) entities);
	}

	public JDBCDrivers createJDBCDrivers(int initialSize) {
		return clone(DBCFGEntityDescriptorEnum.JDBCDrivers, initialSize);
	}

	public JDBCDriver createJDBCDriver() {
		return create(DBCFGEntityDescriptorEnum.JDBCDriver);
	}

	public JDBCDriver createJDBCDriver(DriverName driverName,
			ClassName driverClassName, Files files, Dialect dialect) {
		return create(DBCFGEntityDescriptorEnum.JDBCDriver, driverName,
				driverClassName, files, dialect);
	}

	public IEntityBuilder<JDBCDriver> buildJDBCDriver() {
		return new EntityBuilder<JDBCDriver>(
				create(DBCFGEntityDescriptorEnum.JDBCDriver));
	}

	public Files createFiles() {
		return create(DBCFGEntityDescriptorEnum.Files);
	}

	public Files createFiles(FilePath... entities) {
		return create(DBCFGEntityDescriptorEnum.Files, (IEntity[]) entities);
	}

	public Files createFiles(int initialSize) {
		return clone(DBCFGEntityDescriptorEnum.Files, initialSize);
	}

	public DataSources createDataSources() {
		return create(DBCFGEntityDescriptorEnum.DataSources);
	}

	public DataSources createDataSources(DataSource... entities) {
		return create(DBCFGEntityDescriptorEnum.DataSources,
				(IEntity[]) entities);
	}

	public DataSources createDataSources(int initialSize) {
		return clone(DBCFGEntityDescriptorEnum.DataSources, initialSize);
	}

	public DataSource createDataSource() {
		return create(DBCFGEntityDescriptorEnum.DataSource);
	}

	public DataSource createDataSource(DriverName driverName, Url url,
			ServerName serverName, PortNumber portNumber,
			DatabaseName databaseName, DatabaseSchema databaseSchema,
			UserName userName, Password password) {
		return create(DBCFGEntityDescriptorEnum.DataSource, driverName, url,
				serverName, portNumber, databaseName, databaseSchema, userName,
				password);
	}

	public IEntityBuilder<DataSource> buildDataSource() {
		return new EntityBuilder<DataSource>(
				create(DBCFGEntityDescriptorEnum.DataSource));
	}

	public Index createIndex() {
		return create(DBCFGEntityDescriptorEnum.Index);
	}

	public Index createIndex(int value) {
		return create(DBCFGEntityDescriptorEnum.Index, value);
	}

	public Dialect createDialect() {
		return create(DBCFGEntityDescriptorEnum.Dialect);
	}

	public Dialect createDialect(DialectEnum.Value value) {
		return create(DBCFGEntityDescriptorEnum.Dialect, value);
	}

	public Url createUrl() {
		return create(DBCFGEntityDescriptorEnum.Url);
	}

	public Url createUrl(String value) {
		return create(DBCFGEntityDescriptorEnum.Url, value);
	}

	public ServerName createServerName() {
		return create(DBCFGEntityDescriptorEnum.ServerName);
	}

	public ServerName createServerName(String value) {
		return create(DBCFGEntityDescriptorEnum.ServerName, value);
	}

	public PortNumber createPortNumber() {
		return create(DBCFGEntityDescriptorEnum.PortNumber);
	}

	public PortNumber createPortNumber(int value) {
		return create(DBCFGEntityDescriptorEnum.PortNumber, value);
	}

	public DatabaseName createDatabaseName() {
		return create(DBCFGEntityDescriptorEnum.DatabaseName);
	}

	public DatabaseName createDatabaseName(String value) {
		return create(DBCFGEntityDescriptorEnum.DatabaseName, value);
	}

	public DatabaseSchema createDatabaseSchema() {
		return create(DBCFGEntityDescriptorEnum.DatabaseSchema);
	}

	public DatabaseSchema createDatabaseSchema(String value) {
		return create(DBCFGEntityDescriptorEnum.DatabaseSchema, value);
	}

	public UserName createUserName() {
		return create(DBCFGEntityDescriptorEnum.UserName);
	}

	public UserName createUserName(String value) {
		return create(DBCFGEntityDescriptorEnum.UserName, value);
	}

	public Password createPassword() {
		return create(DBCFGEntityDescriptorEnum.Password);
	}

	public Password createPassword(String value) {
		return create(DBCFGEntityDescriptorEnum.Password, value);
	}

	public DriverName createDriverName() {
		return create(DBCFGEntityDescriptorEnum.DriverName);
	}

	public DriverName createDriverName(String value) {
		return create(DBCFGEntityDescriptorEnum.DriverName, value);
	}

	public ClassName createClassName() {
		return create(DBCFGEntityDescriptorEnum.ClassName);
	}

	public ClassName createClassName(String value) {
		return create(DBCFGEntityDescriptorEnum.ClassName, value);
	}

	public FilePath createFilePath() {
		return create(DBCFGEntityDescriptorEnum.FilePath);
	}

	public FilePath createFilePath(String value) {
		return create(DBCFGEntityDescriptorEnum.FilePath, value);
	}
}
