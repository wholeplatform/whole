package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Drop extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);
}
