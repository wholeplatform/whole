package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface RawValue extends ISQLEntity, SQLExpression {
	public Object getValue();

	public void setValue(Object value);
}
