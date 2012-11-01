package org.whole.lang.dbcfg.model;

/** 
 * @generator Whole
 */
public interface DataSource extends IDBCFGEntity {
	public DriverName getDriverName();

	public void setDriverName(DriverName driverName);

	public Url getUrl();

	public void setUrl(Url url);

	public ServerName getServerName();

	public void setServerName(ServerName serverName);

	public PortNumber getPortNumber();

	public void setPortNumber(PortNumber portNumber);

	public DatabaseName getDatabaseName();

	public void setDatabaseName(DatabaseName databaseName);

	public DatabaseSchema getDatabaseSchema();

	public void setDatabaseSchema(DatabaseSchema databaseSchema);

	public UserName getUserName();

	public void setUserName(UserName userName);

	public Password getPassword();

	public void setPassword(Password password);
}
