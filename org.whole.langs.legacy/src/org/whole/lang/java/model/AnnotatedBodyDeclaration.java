package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface AnnotatedBodyDeclaration extends IJavaEntity, BodyDeclaration {
	public Javadoc getJavadoc();

	public void setJavadoc(Javadoc javadoc);

	public ExtendedModifiers getModifiers();

	public void setModifiers(ExtendedModifiers modifiers);
}
