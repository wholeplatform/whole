package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DataSourceImpl extends AbstractSimpleEntity implements DataSource {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DataSource> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DataSource;
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.DataSource_ord;
	}

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	private DriverName driverName;

	public DriverName getDriverName() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.driverName,
				driverName);
	}

	public void setDriverName(DriverName driverName) {
		notifyChanged(DBCFGFeatureDescriptorEnum.driverName, this.driverName,
				this.driverName = driverName);
	}

	private Url url;

	public Url getUrl() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.url, url);
	}

	public void setUrl(Url url) {
		notifyChanged(DBCFGFeatureDescriptorEnum.url, this.url, this.url = url);
	}

	private ServerName serverName;

	public ServerName getServerName() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.serverName,
				serverName);
	}

	public void setServerName(ServerName serverName) {
		notifyChanged(DBCFGFeatureDescriptorEnum.serverName, this.serverName,
				this.serverName = serverName);
	}

	private PortNumber portNumber;

	public PortNumber getPortNumber() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.portNumber,
				portNumber);
	}

	public void setPortNumber(PortNumber portNumber) {
		notifyChanged(DBCFGFeatureDescriptorEnum.portNumber, this.portNumber,
				this.portNumber = portNumber);
	}

	private DatabaseName databaseName;

	public DatabaseName getDatabaseName() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.databaseName,
				databaseName);
	}

	public void setDatabaseName(DatabaseName databaseName) {
		notifyChanged(DBCFGFeatureDescriptorEnum.databaseName,
				this.databaseName, this.databaseName = databaseName);
	}

	private DatabaseSchema databaseSchema;

	public DatabaseSchema getDatabaseSchema() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.databaseSchema,
				databaseSchema);
	}

	public void setDatabaseSchema(DatabaseSchema databaseSchema) {
		notifyChanged(DBCFGFeatureDescriptorEnum.databaseSchema,
				this.databaseSchema, this.databaseSchema = databaseSchema);
	}

	private UserName userName;

	public UserName getUserName() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.userName, userName);
	}

	public void setUserName(UserName userName) {
		notifyChanged(DBCFGFeatureDescriptorEnum.userName, this.userName,
				this.userName = userName);
	}

	private Password password;

	public Password getPassword() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.password, password);
	}

	public void setPassword(Password password) {
		notifyChanged(DBCFGFeatureDescriptorEnum.password, this.password,
				this.password = password);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDriverName().wGetAdaptee(false);
		case 1:
			return getUrl().wGetAdaptee(false);
		case 2:
			return getServerName().wGetAdaptee(false);
		case 3:
			return getPortNumber().wGetAdaptee(false);
		case 4:
			return getDatabaseName().wGetAdaptee(false);
		case 5:
			return getDatabaseSchema().wGetAdaptee(false);
		case 6:
			return getUserName().wGetAdaptee(false);
		case 7:
			return getPassword().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDriverName(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.DriverName));
			break;
		case 1:
			setUrl(value.wGetAdapter(DBCFGEntityDescriptorEnum.Url));
			break;
		case 2:
			setServerName(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.ServerName));
			break;
		case 3:
			setPortNumber(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.PortNumber));
			break;
		case 4:
			setDatabaseName(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.DatabaseName));
			break;
		case 5:
			setDatabaseSchema(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.DatabaseSchema));
			break;
		case 6:
			setUserName(value.wGetAdapter(DBCFGEntityDescriptorEnum.UserName));
			break;
		case 7:
			setPassword(value.wGetAdapter(DBCFGEntityDescriptorEnum.Password));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 8;
	}
}
