package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface VariableDeclaration extends IJavaScriptEntity, Statement,
		VariableDeclarationOrExpression {
	public VariableDeclarationKind getKind();

	public void setKind(VariableDeclarationKind kind);

	public VariableInitializers getVariables();

	public void setVariables(VariableInitializers variables);
}
