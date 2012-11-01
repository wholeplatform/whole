package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface RealValue extends ISQLEntity, SQLExpression {
	public float getValue();

	public void setValue(float value);
}
