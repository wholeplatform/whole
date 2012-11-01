package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface LabeledStatement extends IJavaScriptEntity, Statement {
	public Labels getLabels();

	public void setLabels(Labels labels);

	public Statement getBody();

	public void setBody(Statement body);
}
