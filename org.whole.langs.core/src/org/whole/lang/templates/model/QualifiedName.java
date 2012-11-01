package org.whole.lang.templates.model;

/** 
 * @generator Whole
 */
public interface QualifiedName extends ITemplatesEntity, Name {
	public SimpleName getQualifier();

	public void setQualifier(SimpleName qualifier);

	public Name getName();

	public void setName(Name name);
}
