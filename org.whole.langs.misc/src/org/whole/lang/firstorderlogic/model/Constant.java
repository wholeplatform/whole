package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Constant extends IFirstOrderLogicEntity, Term {
	public String getValue();

	public void setValue(String value);
}
