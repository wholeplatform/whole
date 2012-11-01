package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Variable extends IFirstOrderLogicEntity, Term {
	public String getValue();

	public void setValue(String value);
}
