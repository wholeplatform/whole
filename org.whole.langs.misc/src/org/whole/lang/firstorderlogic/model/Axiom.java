package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Axiom extends IFirstOrderLogicEntity, Assertion {
	public Name getName();

	public void setName(Name name);

	public Formula getStatement();

	public void setStatement(Formula statement);
}
