package org.whole.lang.dbcfg.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DBCFGModelContext extends EntityContext {
	public DBCFGModelContext(IEntity root) {
		super(root);
	}

	public DBCFGModelContext getDrivers() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.drivers);
	}

	public void setDrivers(DBCFGModelContext drivers) {
		wSet(DBCFGFeatureDescriptorEnum.drivers, drivers);
	}

	public DBCFGModelContext getDataSources() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.dataSources);
	}

	public void setDataSources(DBCFGModelContext dataSources) {
		wSet(DBCFGFeatureDescriptorEnum.dataSources, dataSources);
	}

	public DBCFGModelContext getDataSourceIndex() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.dataSourceIndex);
	}

	public void setDataSourceIndex(DBCFGModelContext dataSourceIndex) {
		wSet(DBCFGFeatureDescriptorEnum.dataSourceIndex, dataSourceIndex);
	}

	public DBCFGModelContext getDriverName() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.driverName);
	}

	public void setDriverName(DBCFGModelContext driverName) {
		wSet(DBCFGFeatureDescriptorEnum.driverName, driverName);
	}

	public DBCFGModelContext getDriverClassName() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.driverClassName);
	}

	public void setDriverClassName(DBCFGModelContext driverClassName) {
		wSet(DBCFGFeatureDescriptorEnum.driverClassName, driverClassName);
	}

	public DBCFGModelContext getFiles() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.files);
	}

	public void setFiles(DBCFGModelContext files) {
		wSet(DBCFGFeatureDescriptorEnum.files, files);
	}

	public DBCFGModelContext getDialect() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.dialect);
	}

	public void setDialect(DBCFGModelContext dialect) {
		wSet(DBCFGFeatureDescriptorEnum.dialect, dialect);
	}

	public DBCFGModelContext getUrl() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.url);
	}

	public void setUrl(DBCFGModelContext url) {
		wSet(DBCFGFeatureDescriptorEnum.url, url);
	}

	public DBCFGModelContext getServerName() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.serverName);
	}

	public void setServerName(DBCFGModelContext serverName) {
		wSet(DBCFGFeatureDescriptorEnum.serverName, serverName);
	}

	public DBCFGModelContext getPortNumber() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.portNumber);
	}

	public void setPortNumber(DBCFGModelContext portNumber) {
		wSet(DBCFGFeatureDescriptorEnum.portNumber, portNumber);
	}

	public DBCFGModelContext getDatabaseName() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.databaseName);
	}

	public void setDatabaseName(DBCFGModelContext databaseName) {
		wSet(DBCFGFeatureDescriptorEnum.databaseName, databaseName);
	}

	public DBCFGModelContext getDatabaseSchema() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.databaseSchema);
	}

	public void setDatabaseSchema(DBCFGModelContext databaseSchema) {
		wSet(DBCFGFeatureDescriptorEnum.databaseSchema, databaseSchema);
	}

	public DBCFGModelContext getUserName() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.userName);
	}

	public void setUserName(DBCFGModelContext userName) {
		wSet(DBCFGFeatureDescriptorEnum.userName, userName);
	}

	public DBCFGModelContext getPassword() {
		return (DBCFGModelContext) wGet(DBCFGFeatureDescriptorEnum.password);
	}

	public void setPassword(DBCFGModelContext password) {
		wSet(DBCFGFeatureDescriptorEnum.password, password);
	}
}
