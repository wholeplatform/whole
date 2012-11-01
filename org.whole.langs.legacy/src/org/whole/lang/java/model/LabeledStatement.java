package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface LabeledStatement extends IJavaEntity, Statement {
	public SimpleName getLabel();

	public void setLabel(SimpleName label);

	public Statement getBody();

	public void setBody(Statement body);
}
