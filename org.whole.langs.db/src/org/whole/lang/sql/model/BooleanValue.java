package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface BooleanValue extends ISQLEntity, BooleanExpression {
	public boolean isValue();

	public void setValue(boolean value);
}
