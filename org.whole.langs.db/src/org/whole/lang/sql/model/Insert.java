package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Insert extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);

	public Values getValues();

	public void setValues(Values values);
}
