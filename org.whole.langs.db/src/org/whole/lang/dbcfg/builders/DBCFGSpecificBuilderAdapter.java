package org.whole.lang.dbcfg.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.dbcfg.model.DialectEnum;

/** 
 * @generator Whole
 */
public class DBCFGSpecificBuilderAdapter extends GenericBuilderContext
		implements IDBCFGBuilder {
	public DBCFGSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public DBCFGSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void password() {
		wFeature(DBCFGFeatureDescriptorEnum.password);
	}

	public void userName() {
		wFeature(DBCFGFeatureDescriptorEnum.userName);
	}

	public void databaseSchema() {
		wFeature(DBCFGFeatureDescriptorEnum.databaseSchema);
	}

	public void databaseName() {
		wFeature(DBCFGFeatureDescriptorEnum.databaseName);
	}

	public void portNumber() {
		wFeature(DBCFGFeatureDescriptorEnum.portNumber);
	}

	public void serverName() {
		wFeature(DBCFGFeatureDescriptorEnum.serverName);
	}

	public void url() {
		wFeature(DBCFGFeatureDescriptorEnum.url);
	}

	public void dialect() {
		wFeature(DBCFGFeatureDescriptorEnum.dialect);
	}

	public void files() {
		wFeature(DBCFGFeatureDescriptorEnum.files);
	}

	public void driverClassName() {
		wFeature(DBCFGFeatureDescriptorEnum.driverClassName);
	}

	public void driverName() {
		wFeature(DBCFGFeatureDescriptorEnum.driverName);
	}

	public void dataSourceIndex() {
		wFeature(DBCFGFeatureDescriptorEnum.dataSourceIndex);
	}

	public void dataSources() {
		wFeature(DBCFGFeatureDescriptorEnum.dataSources);
	}

	public void drivers() {
		wFeature(DBCFGFeatureDescriptorEnum.drivers);
	}

	public void visit() {
	}

	public void DBConfiguration() {
		wEntity(DBCFGEntityDescriptorEnum.DBConfiguration);
	}

	public void DBConfiguration_() {
		wEntity_(DBCFGEntityDescriptorEnum.DBConfiguration);
	}

	public void _DBConfiguration() {
		_wEntity(DBCFGEntityDescriptorEnum.DBConfiguration);
	}

	public void JDBCDrivers() {
		wEntity(DBCFGEntityDescriptorEnum.JDBCDrivers);
	}

	public void JDBCDrivers_() {
		wEntity_(DBCFGEntityDescriptorEnum.JDBCDrivers);
	}

	public void JDBCDrivers_(int initialCapacity) {
		wEntity_(DBCFGEntityDescriptorEnum.JDBCDrivers, initialCapacity);
	}

	public void _JDBCDrivers() {
		_wEntity(DBCFGEntityDescriptorEnum.JDBCDrivers);
	}

	public void JDBCDriver() {
		wEntity(DBCFGEntityDescriptorEnum.JDBCDriver);
	}

	public void JDBCDriver_() {
		wEntity_(DBCFGEntityDescriptorEnum.JDBCDriver);
	}

	public void _JDBCDriver() {
		_wEntity(DBCFGEntityDescriptorEnum.JDBCDriver);
	}

	public void Files() {
		wEntity(DBCFGEntityDescriptorEnum.Files);
	}

	public void Files_() {
		wEntity_(DBCFGEntityDescriptorEnum.Files);
	}

	public void Files_(int initialCapacity) {
		wEntity_(DBCFGEntityDescriptorEnum.Files, initialCapacity);
	}

	public void _Files() {
		_wEntity(DBCFGEntityDescriptorEnum.Files);
	}

	public void DataSources() {
		wEntity(DBCFGEntityDescriptorEnum.DataSources);
	}

	public void DataSources_() {
		wEntity_(DBCFGEntityDescriptorEnum.DataSources);
	}

	public void DataSources_(int initialCapacity) {
		wEntity_(DBCFGEntityDescriptorEnum.DataSources, initialCapacity);
	}

	public void _DataSources() {
		_wEntity(DBCFGEntityDescriptorEnum.DataSources);
	}

	public void DataSource() {
		wEntity(DBCFGEntityDescriptorEnum.DataSource);
	}

	public void DataSource_() {
		wEntity_(DBCFGEntityDescriptorEnum.DataSource);
	}

	public void _DataSource() {
		_wEntity(DBCFGEntityDescriptorEnum.DataSource);
	}

	public void Index() {
		wEntity(DBCFGEntityDescriptorEnum.Index);
	}

	public void Index(int value) {
		wEntity(DBCFGEntityDescriptorEnum.Index, value);
	}

	public void Dialect() {
		wEntity(DBCFGEntityDescriptorEnum.Dialect);
	}

	public void Dialect(DialectEnum.Value value) {
		wEntity(DBCFGEntityDescriptorEnum.Dialect, value);
	}

	public void Dialect(String value) {
		wEntity(DBCFGEntityDescriptorEnum.Dialect, value);
	}

	public void Url() {
		wEntity(DBCFGEntityDescriptorEnum.Url);
	}

	public void Url(String value) {
		wEntity(DBCFGEntityDescriptorEnum.Url, value);
	}

	public void ServerName() {
		wEntity(DBCFGEntityDescriptorEnum.ServerName);
	}

	public void ServerName(String value) {
		wEntity(DBCFGEntityDescriptorEnum.ServerName, value);
	}

	public void PortNumber() {
		wEntity(DBCFGEntityDescriptorEnum.PortNumber);
	}

	public void PortNumber(int value) {
		wEntity(DBCFGEntityDescriptorEnum.PortNumber, value);
	}

	public void DatabaseName() {
		wEntity(DBCFGEntityDescriptorEnum.DatabaseName);
	}

	public void DatabaseName(String value) {
		wEntity(DBCFGEntityDescriptorEnum.DatabaseName, value);
	}

	public void DatabaseSchema() {
		wEntity(DBCFGEntityDescriptorEnum.DatabaseSchema);
	}

	public void DatabaseSchema(String value) {
		wEntity(DBCFGEntityDescriptorEnum.DatabaseSchema, value);
	}

	public void UserName() {
		wEntity(DBCFGEntityDescriptorEnum.UserName);
	}

	public void UserName(String value) {
		wEntity(DBCFGEntityDescriptorEnum.UserName, value);
	}

	public void Password() {
		wEntity(DBCFGEntityDescriptorEnum.Password);
	}

	public void Password(String value) {
		wEntity(DBCFGEntityDescriptorEnum.Password, value);
	}

	public void DriverName() {
		wEntity(DBCFGEntityDescriptorEnum.DriverName);
	}

	public void DriverName(String value) {
		wEntity(DBCFGEntityDescriptorEnum.DriverName, value);
	}

	public void ClassName() {
		wEntity(DBCFGEntityDescriptorEnum.ClassName);
	}

	public void ClassName(String value) {
		wEntity(DBCFGEntityDescriptorEnum.ClassName, value);
	}

	public void FilePath() {
		wEntity(DBCFGEntityDescriptorEnum.FilePath);
	}

	public void FilePath(String value) {
		wEntity(DBCFGEntityDescriptorEnum.FilePath, value);
	}
}
