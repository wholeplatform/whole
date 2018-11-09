package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ColumnName extends ISQLEntity, SQLExpression {
	public String getValue();

	public void setValue(String value);
}
