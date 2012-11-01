package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface FieldDeclaration extends IJavaEntity, AnnotatedBodyDeclaration {
	public Type getType();

	public void setType(Type type);

	public VariableDeclarationFragments getFragments();

	public void setFragments(VariableDeclarationFragments fragments);
}
