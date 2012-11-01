package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ClassDeclaration extends IJavaEntity, TypeDeclaration {
	public TypeParameters getTypeParameters();

	public void setTypeParameters(TypeParameters typeParameters);

	public Type getSuperclassType();

	public void setSuperclassType(Type superclassType);

	public Types getSuperInterfaceTypes();

	public void setSuperInterfaceTypes(Types superInterfaceTypes);

	public BodyDeclarations getBodyDeclarations();

	public void setBodyDeclarations(BodyDeclarations bodyDeclarations);
}
