package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Implication extends IFirstOrderLogicEntity, Formula {
	public Formula getAntecedent();

	public void setAntecedent(Formula antecedent);

	public Formula getConsequent();

	public void setConsequent(Formula consequent);
}
