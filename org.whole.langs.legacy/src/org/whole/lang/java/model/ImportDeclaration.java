package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ImportDeclaration extends IJavaEntity {
	public Name getName();

	public void setName(Name name);

	public ImportModifier getOnDemand();

	public void setOnDemand(ImportModifier onDemand);

	public ImportModifier getStatic();

	public void setStatic(ImportModifier _static);
}
