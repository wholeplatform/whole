package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Xor extends IFirstOrderLogicEntity, Formula {
	public Formula getLeftFormula();

	public void setLeftFormula(Formula leftFormula);

	public Formula getRightFormula();

	public void setRightFormula(Formula rightFormula);
}
