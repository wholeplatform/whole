package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Builder extends IMathEntity, Constructor {
	public Expression getElement();

	public void setElement(Expression element);

	public Expression getRule();

	public void setRule(Expression rule);
}
