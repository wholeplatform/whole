package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface Delete extends IQueriesEntity, PathExpression {
	public PathExpression getFromClause();

	public void setFromClause(PathExpression fromClause);
}
