package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface Metadata extends IArtifactsEntity {
	public Copyright getCopyright();

	public void setCopyright(Copyright copyright);

	public License getLicense();

	public void setLicense(License license);

	public Author getAuthor();

	public void setAuthor(Author author);

	public Attributes getAttributes();

	public void setAttributes(Attributes attributes);

	public PersistenceKitId getPersistenceKitId();

	public void setPersistenceKitId(PersistenceKitId persistenceKitId);
}
