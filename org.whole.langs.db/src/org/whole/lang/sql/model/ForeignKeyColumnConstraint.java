package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ForeignKeyColumnConstraint extends ISQLEntity,
		ColumnConstraint {
	public TableName getForeignTableName();

	public void setForeignTableName(TableName foreignTableName);

	public ColumnName getForeignColumnName();

	public void setForeignColumnName(ColumnName foreignColumnName);
}
