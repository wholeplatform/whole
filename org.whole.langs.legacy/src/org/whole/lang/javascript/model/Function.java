package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface Function extends IJavaScriptEntity {
	public Identifier getId();

	public void setId(Identifier id);

	public Expressions getParams();

	public void setParams(Expressions params);

	public FunctionBody getBody();

	public void setBody(FunctionBody body);
}
