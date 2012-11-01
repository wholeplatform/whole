package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface CartesianInsert extends IQueriesEntity, PathExpression {
	public Placement getPlacement();

	public void setPlacement(Placement placement);

	public PathExpression getFromClause();

	public void setFromClause(PathExpression fromClause);

	public PathExpression getValuesClause();

	public void setValuesClause(PathExpression valuesClause);
}
