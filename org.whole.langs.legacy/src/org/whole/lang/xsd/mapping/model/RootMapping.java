package org.whole.lang.xsd.mapping.model;

/** 
 * @generator Whole
 */
public interface RootMapping extends IMappingEntity, Mapping {
	public NCName getName();

	public void setName(NCName name);

	public URI getEntityType();

	public void setEntityType(URI entityType);
}
