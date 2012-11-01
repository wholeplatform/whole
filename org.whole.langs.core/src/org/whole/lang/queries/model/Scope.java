package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface Scope extends IQueriesEntity, StepExpression {
	public Names getLocalNames();

	public void setLocalNames(Names localNames);

	public PathExpression getExpression();

	public void setExpression(PathExpression expression);
}
