package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface LetStatement extends IJavaScriptEntity, Statement, Let {
	public Statement getBody();

	public void setBody(Statement body);
}
