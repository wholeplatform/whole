package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface IntValue extends ISQLEntity, SQLExpression {
	public int getValue();

	public void setValue(int value);
}
