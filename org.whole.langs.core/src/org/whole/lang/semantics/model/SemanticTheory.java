package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface SemanticTheory extends ISemanticsEntity {
	public URI getUri();

	public void setUri(URI uri);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Name getName();

	public void setName(Name name);

	public Version getVersion();

	public void setVersion(Version version);

	public SemanticFunctions getFunctions();

	public void setFunctions(SemanticFunctions functions);
}
