package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Truncate extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);
}
