package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Import extends IXsdEntity, SchemaDirective, Annotated {
	public AnyURI getNamespace();

	public void setNamespace(AnyURI namespace);

	public AnyURI getSchemaLocation();

	public void setSchemaLocation(AnyURI schemaLocation);
}
