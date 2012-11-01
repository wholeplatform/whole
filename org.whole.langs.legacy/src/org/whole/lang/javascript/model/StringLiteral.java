package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface StringLiteral extends IJavaScriptEntity, Literal {
	public StringData getValue();

	public void setValue(StringData value);

	public StringData getQuote();

	public void setQuote(StringData quote);
}
