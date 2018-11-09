package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface StringValue extends ISQLEntity, SQLExpression {
	public String getValue();

	public void setValue(String value);
}
