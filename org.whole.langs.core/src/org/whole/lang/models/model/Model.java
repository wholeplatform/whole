package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface Model extends IModelsEntity {
	public SimpleName getName();

	public void setName(SimpleName name);

	public TypeRelations getTypeRelations();

	public void setTypeRelations(TypeRelations typeRelations);

	public ModelDeclarations getDeclarations();

	public void setDeclarations(ModelDeclarations declarations);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Version getVersion();

	public void setVersion(Version version);

	public URI getUri();

	public void setUri(URI uri);
}
