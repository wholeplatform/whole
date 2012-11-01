package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface Singleton extends IQueriesEntity, Expression {
	public PathExpression getExpression();

	public void setExpression(PathExpression expression);
}
