package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface DecimalValue extends ISQLEntity, SQLExpression {
	public java.math.BigDecimal getValue();

	public void setValue(java.math.BigDecimal value);
}
