package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface DoubleValue extends ISQLEntity, SQLExpression {
	public double getValue();

	public void setValue(double value);
}
