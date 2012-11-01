package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface AnnotationTypeMemberDeclaration extends IJavaEntity,
		AnnotatedBodyDeclaration {
	public SimpleName getName();

	public void setName(SimpleName name);

	public Type getType();

	public void setType(Type type);

	public Expression getDefault();

	public void setDefault(Expression _default);
}
