package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface VariableInitializer extends IJavaScriptEntity {
	public Expression getId();

	public void setId(Expression id);

	public Expression getInit();

	public void setInit(Expression init);
}
