package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface AlterTable extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public AlterAction getAction();

	public void setAction(AlterAction action);
}
