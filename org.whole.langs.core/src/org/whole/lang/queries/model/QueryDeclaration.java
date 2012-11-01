package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface QueryDeclaration extends IQueriesEntity, PathExpression {
	public Name getName();

	public void setName(Name name);

	public Names getParameters();

	public void setParameters(Names parameters);

	public PathExpression getBody();

	public void setBody(PathExpression body);
}
