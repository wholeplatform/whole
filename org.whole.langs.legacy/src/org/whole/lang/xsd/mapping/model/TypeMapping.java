package org.whole.lang.xsd.mapping.model;

/** 
 * @generator Whole
 */
public interface TypeMapping extends IMappingEntity, ContextMapping {
	public NCName getName();

	public void setName(NCName name);

	public URI getEntityType();

	public void setEntityType(URI entityType);

	public URI getFeatureType();

	public void setFeatureType(URI featureType);
}
