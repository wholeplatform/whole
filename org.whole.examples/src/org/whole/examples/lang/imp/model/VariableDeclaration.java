package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface VariableDeclaration extends IImpEntity, Declaration {
	public Expression getInitializer();

	public void setInitializer(Expression initializer);
}
