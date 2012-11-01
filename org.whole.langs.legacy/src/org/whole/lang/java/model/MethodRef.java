package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface MethodRef extends IJavaEntity, DocElement {
	public Name getQualifier();

	public void setQualifier(Name qualifier);

	public SimpleName getName();

	public void setName(SimpleName name);

	public MethodRefParameters getParameters();

	public void setParameters(MethodRefParameters parameters);
}
