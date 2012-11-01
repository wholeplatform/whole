package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface BigIntValue extends ISQLEntity, SQLExpression {
	public long getValue();

	public void setValue(long value);
}
