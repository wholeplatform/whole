package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Update extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public SetClauses getSetClauses();

	public void setSetClauses(SetClauses setClauses);

	public FromClauses getFromClauses();

	public void setFromClauses(FromClauses fromClauses);

	public SQLExpression getWhereExpr();

	public void setWhereExpr(SQLExpression whereExpr);

	public IntValue getLimit();

	public void setLimit(IntValue limit);
}
