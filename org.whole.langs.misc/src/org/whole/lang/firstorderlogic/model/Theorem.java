package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Theorem extends IFirstOrderLogicEntity, Assertion {
	public Name getName();

	public void setName(Name name);

	public Formula getStatement();

	public void setStatement(Formula statement);

	public Formulae getProof();

	public void setProof(Formulae proof);
}
