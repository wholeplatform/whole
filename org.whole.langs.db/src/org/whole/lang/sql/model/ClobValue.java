package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ClobValue extends ISQLEntity, SQLExpression {
	public java.sql.Clob getValue();

	public void setValue(java.sql.Clob value);
}
