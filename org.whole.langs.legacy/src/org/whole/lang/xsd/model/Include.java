package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Include extends IXsdEntity, SchemaDirective, Annotated {
	public AnyURI getSchemaLocation();

	public void setSchemaLocation(AnyURI schemaLocation);
}
