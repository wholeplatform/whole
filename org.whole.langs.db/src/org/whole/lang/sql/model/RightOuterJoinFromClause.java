package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface RightOuterJoinFromClause extends ISQLEntity, FromClause {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public TableName getOuterTable();

	public void setOuterTable(TableName outerTable);

	public SQLExpression getOnExpression();

	public void setOnExpression(SQLExpression onExpression);
}
