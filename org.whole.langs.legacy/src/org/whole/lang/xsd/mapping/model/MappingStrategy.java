package org.whole.lang.xsd.mapping.model;

/** 
 * @generator Whole
 */
public interface MappingStrategy extends IMappingEntity {
	public URI getNamespace();

	public void setNamespace(URI namespace);

	public URI getSchemaLocation();

	public void setSchemaLocation(URI schemaLocation);

	public BooleanType getSynthesized();

	public void setSynthesized(BooleanType synthesized);

	public BooleanType getElementsFormQualified();

	public void setElementsFormQualified(BooleanType elementsFormQualified);

	public BooleanType getAttributesFormQualified();

	public void setAttributesFormQualified(BooleanType attributesFormQualified);

	public URI getMixedDataType();

	public void setMixedDataType(URI mixedDataType);

	public Types getMixedTypes();

	public void setMixedTypes(Types mixedTypes);

	public Mappings getMappings();

	public void setMappings(Mappings mappings);

	public DataTypes getDataTypes();

	public void setDataTypes(DataTypes dataTypes);
}
