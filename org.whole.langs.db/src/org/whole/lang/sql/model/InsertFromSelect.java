package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface InsertFromSelect extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);

	public SelectSQLStatement getSelect();

	public void setSelect(SelectSQLStatement select);
}
