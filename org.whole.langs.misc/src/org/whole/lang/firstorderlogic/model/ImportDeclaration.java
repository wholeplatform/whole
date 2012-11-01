package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface ImportDeclaration extends IFirstOrderLogicEntity {
	public TheoryName getLanguage();

	public void setLanguage(TheoryName language);

	public Name getAlias();

	public void setAlias(Name alias);
}
