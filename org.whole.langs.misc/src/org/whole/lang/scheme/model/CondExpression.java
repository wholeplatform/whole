package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface CondExpression extends ISchemeEntity, SchemeExpression {
	public Branches getBranches();

	public void setBranches(Branches branches);

	public SchemeExpression getElseBody();

	public void setElseBody(SchemeExpression elseBody);
}
