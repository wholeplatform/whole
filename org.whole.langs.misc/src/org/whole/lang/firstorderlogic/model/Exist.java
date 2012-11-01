package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Exist extends IFirstOrderLogicEntity, Formula {
	public Parameters getParameters();

	public void setParameters(Parameters parameters);

	public Formula getFormula();

	public void setFormula(Formula formula);
}
