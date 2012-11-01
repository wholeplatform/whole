package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Select extends ISQLEntity, SelectSQLStatement {
	public SelectType getSelectType();

	public void setSelectType(SelectType selectType);

	public ColumnExpressions getColumnExprs();

	public void setColumnExprs(ColumnExpressions columnExprs);

	public FromClauses getFromClauses();

	public void setFromClauses(FromClauses fromClauses);

	public SQLExpression getWhereExpr();

	public void setWhereExpr(SQLExpression whereExpr);

	public SQLExpressions getGroupByExprs();

	public void setGroupByExprs(SQLExpressions groupByExprs);

	public SQLExpression getHavingExpr();

	public void setHavingExpr(SQLExpression havingExpr);

	public OrderByColumnExpressions getOrderByColumnExprs();

	public void setOrderByColumnExprs(
			OrderByColumnExpressions orderByColumnExprs);
}
