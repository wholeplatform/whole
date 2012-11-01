package org.whole.lang.scripts.model;

/** 
 * @generator Whole
 */
public interface Script extends IScriptsEntity {
	public LanguageName getLanguageName();

	public void setLanguageName(LanguageName languageName);

	public Source getSource();

	public void setSource(Source source);
}
