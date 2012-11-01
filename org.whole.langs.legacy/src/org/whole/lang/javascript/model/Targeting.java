package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface Targeting extends IJavaScriptEntity, Statement {
	public Identifier getTarget();

	public void setTarget(Identifier target);
}
