package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface TypeDeclaration extends IJavaEntity, AnnotatedBodyDeclaration {
	public SimpleName getName();

	public void setName(SimpleName name);

	public BodyDeclarations getBodyDeclarations();

	public void setBodyDeclarations(BodyDeclarations bodyDeclarations);
}
