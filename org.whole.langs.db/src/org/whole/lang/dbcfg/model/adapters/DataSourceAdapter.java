package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DataSourceAdapter extends AbstractEntityAdapter implements
		DataSource {
	private static final long serialVersionUID = 1;

	public DataSourceAdapter(IEntity implementor) {
		super(implementor);
	}

	public DataSourceAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DataSource> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DataSource;
	}

	public DriverName getDriverName() {
		return wGet(DBCFGFeatureDescriptorEnum.driverName).wGetAdapter(
				DBCFGEntityDescriptorEnum.DriverName);
	}

	public void setDriverName(DriverName driverName) {
		wSet(DBCFGFeatureDescriptorEnum.driverName, driverName);
	}

	public Url getUrl() {
		return wGet(DBCFGFeatureDescriptorEnum.url).wGetAdapter(
				DBCFGEntityDescriptorEnum.Url);
	}

	public void setUrl(Url url) {
		wSet(DBCFGFeatureDescriptorEnum.url, url);
	}

	public ServerName getServerName() {
		return wGet(DBCFGFeatureDescriptorEnum.serverName).wGetAdapter(
				DBCFGEntityDescriptorEnum.ServerName);
	}

	public void setServerName(ServerName serverName) {
		wSet(DBCFGFeatureDescriptorEnum.serverName, serverName);
	}

	public PortNumber getPortNumber() {
		return wGet(DBCFGFeatureDescriptorEnum.portNumber).wGetAdapter(
				DBCFGEntityDescriptorEnum.PortNumber);
	}

	public void setPortNumber(PortNumber portNumber) {
		wSet(DBCFGFeatureDescriptorEnum.portNumber, portNumber);
	}

	public DatabaseName getDatabaseName() {
		return wGet(DBCFGFeatureDescriptorEnum.databaseName).wGetAdapter(
				DBCFGEntityDescriptorEnum.DatabaseName);
	}

	public void setDatabaseName(DatabaseName databaseName) {
		wSet(DBCFGFeatureDescriptorEnum.databaseName, databaseName);
	}

	public DatabaseSchema getDatabaseSchema() {
		return wGet(DBCFGFeatureDescriptorEnum.databaseSchema).wGetAdapter(
				DBCFGEntityDescriptorEnum.DatabaseSchema);
	}

	public void setDatabaseSchema(DatabaseSchema databaseSchema) {
		wSet(DBCFGFeatureDescriptorEnum.databaseSchema, databaseSchema);
	}

	public UserName getUserName() {
		return wGet(DBCFGFeatureDescriptorEnum.userName).wGetAdapter(
				DBCFGEntityDescriptorEnum.UserName);
	}

	public void setUserName(UserName userName) {
		wSet(DBCFGFeatureDescriptorEnum.userName, userName);
	}

	public Password getPassword() {
		return wGet(DBCFGFeatureDescriptorEnum.password).wGetAdapter(
				DBCFGEntityDescriptorEnum.Password);
	}

	public void setPassword(Password password) {
		wSet(DBCFGFeatureDescriptorEnum.password, password);
	}
}
