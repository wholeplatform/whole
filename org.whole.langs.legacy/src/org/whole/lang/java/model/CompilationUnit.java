package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface CompilationUnit extends IJavaEntity {
	public PackageDeclaration getPackage();

	public void setPackage(PackageDeclaration _package);

	public ImportDeclarations getImports();

	public void setImports(ImportDeclarations imports);

	public TypeDeclarations getTypes();

	public void setTypes(TypeDeclarations types);
}
