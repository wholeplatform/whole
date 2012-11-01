package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface RegExpLiteral extends IJavaScriptEntity, Literal {
	public StringData getValue();

	public void setValue(StringData value);

	public StringData getFlags();

	public void setFlags(StringData flags);
}
