package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface For extends IQueriesEntity, PathExpression {
	public PathExpression getFromClause();

	public void setFromClause(PathExpression fromClause);

	public PathExpression getExpression();

	public void setExpression(PathExpression expression);
}
