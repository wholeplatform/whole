package org.whole.lang.xsd.mapping.model;

/** 
 * @generator Whole
 */
public interface ContentMapping extends IMappingEntity, ContextMapping {
	public URI getEntityType();

	public void setEntityType(URI entityType);

	public URI getFeatureType();

	public void setFeatureType(URI featureType);
}
