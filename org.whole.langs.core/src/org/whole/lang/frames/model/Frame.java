package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Frame extends IFramesEntity {
	public URI getUri();

	public void setUri(URI uri);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Name getName();

	public void setName(Name name);

	public Version getVersion();

	public void setVersion(Version version);

	public Resources getImports();

	public void setImports(Resources imports);

	public Features getVariability();

	public void setVariability(Features variability);

	public Relations getRelations();

	public void setRelations(Relations relations);

	public Content getContent();

	public void setContent(Content content);
}
