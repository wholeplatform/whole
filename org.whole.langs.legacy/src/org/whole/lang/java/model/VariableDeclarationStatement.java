package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface VariableDeclarationStatement extends IJavaEntity, Statement {
	public ExtendedModifiers getModifiers();

	public void setModifiers(ExtendedModifiers modifiers);

	public Type getType();

	public void setType(Type type);

	public VariableDeclarationFragments getFragments();

	public void setFragments(VariableDeclarationFragments fragments);
}
