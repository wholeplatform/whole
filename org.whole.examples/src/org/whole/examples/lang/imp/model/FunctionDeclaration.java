package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface FunctionDeclaration extends IImpEntity, Declaration {
	public Parameters getParameters();

	public void setParameters(Parameters parameters);

	public Statement getBody();

	public void setBody(Statement body);
}
