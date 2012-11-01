package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ObjectLiteral extends IJavaScriptEntity, DestructuringForm,
		Expression {
	public ObjectProperties getProperties();

	public void setProperties(ObjectProperties properties);
}
