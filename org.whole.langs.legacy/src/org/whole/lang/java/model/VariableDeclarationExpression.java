package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface VariableDeclarationExpression extends IJavaEntity, Expression {
	public ExtendedModifiers getModifiers();

	public void setModifiers(ExtendedModifiers modifiers);

	public Type getType();

	public void setType(Type type);

	public VariableDeclarationFragments getFragments();

	public void setFragments(VariableDeclarationFragments fragments);
}
