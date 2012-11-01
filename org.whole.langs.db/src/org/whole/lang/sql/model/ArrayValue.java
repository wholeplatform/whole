package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ArrayValue extends ISQLEntity, SQLExpression {
	public Object getValue();

	public void setValue(Object value);
}
