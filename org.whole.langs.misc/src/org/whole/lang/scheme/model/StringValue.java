package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface StringValue extends ISchemeEntity, ConstExpression {
	public String getValue();

	public void setValue(String value);
}
