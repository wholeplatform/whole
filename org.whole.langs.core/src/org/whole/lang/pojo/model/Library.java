package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface Library extends IPojoEntity {
	public Annotations getAnnotations();

	public void setAnnotations(Annotations annotations);

	public Name getName();

	public void setName(Name name);

	public LanguageURI getLanguageURI();

	public void setLanguageURI(LanguageURI languageURI);

	public Declarations getDeclarations();

	public void setDeclarations(Declarations declarations);
}
