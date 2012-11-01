package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ObjectProperty extends IJavaScriptEntity {
	public LiteralOrIdentifier getKey();

	public void setKey(LiteralOrIdentifier key);

	public Expression getValue();

	public void setValue(Expression value);
}
