package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface LanguageDescriptor extends IGrammarsEntity, TargetLanguage {
	public URI getUri();

	public void setUri(URI uri);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Name getName();

	public void setName(Name name);

	public Version getVersion();

	public void setVersion(Version version);
}
