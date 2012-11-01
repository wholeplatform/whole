package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface FunctionExpression extends ISQLEntity, SQLExpression {
	public FunctionName getFunctionName();

	public void setFunctionName(FunctionName functionName);

	public SQLExpressions getParams();

	public void setParams(SQLExpressions params);
}
