package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface EnumDeclaration extends IJavaEntity, TypeDeclaration {
	public Types getSuperInterfaceTypes();

	public void setSuperInterfaceTypes(Types superInterfaceTypes);

	public EnumConstants getEnumConstants();

	public void setEnumConstants(EnumConstants enumConstants);

	public BodyDeclarations getBodyDeclarations();

	public void setBodyDeclarations(BodyDeclarations bodyDeclarations);
}
