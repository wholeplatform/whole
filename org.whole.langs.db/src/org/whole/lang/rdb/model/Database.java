package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface Database extends IRDBEntity {
	public URI getUri();

	public void setUri(URI uri);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Schemas getSchemas();

	public void setSchemas(Schemas schemas);
}
