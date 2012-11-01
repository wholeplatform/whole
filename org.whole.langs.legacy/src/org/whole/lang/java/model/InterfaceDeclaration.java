package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface InterfaceDeclaration extends IJavaEntity, TypeDeclaration {
	public TypeParameters getTypeParameters();

	public void setTypeParameters(TypeParameters typeParameters);

	public Types getSuperInterfaceTypes();

	public void setSuperInterfaceTypes(Types superInterfaceTypes);

	public BodyDeclarations getBodyDeclarations();

	public void setBodyDeclarations(BodyDeclarations bodyDeclarations);
}
