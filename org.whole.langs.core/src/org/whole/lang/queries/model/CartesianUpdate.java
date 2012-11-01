package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface CartesianUpdate extends IQueriesEntity, PathExpression {
	public PathExpression getFromClause();

	public void setFromClause(PathExpression fromClause);

	public PathExpression getValuesClause();

	public void setValuesClause(PathExpression valuesClause);
}
