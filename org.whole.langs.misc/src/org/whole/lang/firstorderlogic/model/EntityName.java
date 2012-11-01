package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface EntityName extends IFirstOrderLogicEntity, Path {
	public LanguageName getLanguage();

	public void setLanguage(LanguageName language);

	public Name getEntityName();

	public void setEntityName(Name entityName);
}
