package org.whole.lang.dbcfg.model;

/** 
 * @generator Whole
 */
public interface DBConfiguration extends IDBCFGEntity {
	public JDBCDrivers getDrivers();

	public void setDrivers(JDBCDrivers drivers);

	public DataSources getDataSources();

	public void setDataSources(DataSources dataSources);

	public Index getDataSourceIndex();

	public void setDataSourceIndex(Index dataSourceIndex);
}
