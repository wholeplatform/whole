package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface EnumConstantDeclaration extends IJavaEntity,
		AnnotatedBodyDeclaration {
	public SimpleName getName();

	public void setName(SimpleName name);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);

	public AnonymousClassDeclaration getAnonymousClassDeclaration();

	public void setAnonymousClassDeclaration(
			AnonymousClassDeclaration anonymousClassDeclaration);
}
