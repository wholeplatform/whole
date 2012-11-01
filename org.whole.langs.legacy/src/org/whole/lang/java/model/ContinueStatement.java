package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ContinueStatement extends IJavaEntity, Statement {
	public SimpleName getLabel();

	public void setLabel(SimpleName label);
}
