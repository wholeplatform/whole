package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface IntValue extends ISchemeEntity, ConstExpression {
	public int getValue();

	public void setValue(int value);
}
