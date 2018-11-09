package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface TimestampValue extends ISQLEntity, SQLExpression {
	public java.sql.Timestamp getValue();

	public void setValue(java.sql.Timestamp value);
}
