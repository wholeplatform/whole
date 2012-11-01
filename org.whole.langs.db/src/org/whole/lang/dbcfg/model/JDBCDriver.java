package org.whole.lang.dbcfg.model;

/** 
 * @generator Whole
 */
public interface JDBCDriver extends IDBCFGEntity {
	public DriverName getDriverName();

	public void setDriverName(DriverName driverName);

	public ClassName getDriverClassName();

	public void setDriverClassName(ClassName driverClassName);

	public Files getFiles();

	public void setFiles(Files files);

	public Dialect getDialect();

	public void setDialect(Dialect dialect);
}
