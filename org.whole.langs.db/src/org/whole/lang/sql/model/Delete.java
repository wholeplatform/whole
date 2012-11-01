package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Delete extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public SQLExpression getWhereExpr();

	public void setWhereExpr(SQLExpression whereExpr);

	public IntValue getLimit();

	public void setLimit(IntValue limit);
}
