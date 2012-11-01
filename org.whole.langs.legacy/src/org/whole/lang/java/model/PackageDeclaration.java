package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface PackageDeclaration extends IJavaEntity {
	public Javadoc getJavadoc();

	public void setJavadoc(Javadoc javadoc);

	public Annotations getAnnotations();

	public void setAnnotations(Annotations annotations);

	public Name getName();

	public void setName(Name name);
}
