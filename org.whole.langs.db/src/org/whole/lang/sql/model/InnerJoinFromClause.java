package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface InnerJoinFromClause extends ISQLEntity, FromClause {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public TableName getInnerTable();

	public void setInnerTable(TableName innerTable);

	public SQLExpression getOnExpression();

	public void setOnExpression(SQLExpression onExpression);
}
