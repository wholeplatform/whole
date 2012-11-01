package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ArrayLiteral extends IJavaScriptEntity, DestructuringForm,
		Expression {
	public Expressions getElements();

	public void setElements(Expressions elements);
}
