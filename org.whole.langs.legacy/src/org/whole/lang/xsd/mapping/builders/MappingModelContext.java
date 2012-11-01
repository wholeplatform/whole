package org.whole.lang.xsd.mapping.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingModelContext extends EntityContext {
	public MappingModelContext(IEntity root) {
		super(root);
	}

	public MappingModelContext getNamespace() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.namespace);
	}

	public void setNamespace(MappingModelContext namespace) {
		wSet(MappingFeatureDescriptorEnum.namespace, namespace);
	}

	public MappingModelContext getSchemaLocation() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.schemaLocation);
	}

	public void setSchemaLocation(MappingModelContext schemaLocation) {
		wSet(MappingFeatureDescriptorEnum.schemaLocation, schemaLocation);
	}

	public MappingModelContext getSynthesized() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.synthesized);
	}

	public void setSynthesized(MappingModelContext synthesized) {
		wSet(MappingFeatureDescriptorEnum.synthesized, synthesized);
	}

	public MappingModelContext getElementsFormQualified() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.elementsFormQualified);
	}

	public void setElementsFormQualified(
			MappingModelContext elementsFormQualified) {
		wSet(MappingFeatureDescriptorEnum.elementsFormQualified,
				elementsFormQualified);
	}

	public MappingModelContext getAttributesFormQualified() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.attributesFormQualified);
	}

	public void setAttributesFormQualified(
			MappingModelContext attributesFormQualified) {
		wSet(MappingFeatureDescriptorEnum.attributesFormQualified,
				attributesFormQualified);
	}

	public MappingModelContext getMixedDataType() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.mixedDataType);
	}

	public void setMixedDataType(MappingModelContext mixedDataType) {
		wSet(MappingFeatureDescriptorEnum.mixedDataType, mixedDataType);
	}

	public MappingModelContext getMixedTypes() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.mixedTypes);
	}

	public void setMixedTypes(MappingModelContext mixedTypes) {
		wSet(MappingFeatureDescriptorEnum.mixedTypes, mixedTypes);
	}

	public MappingModelContext getMappings() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.mappings);
	}

	public void setMappings(MappingModelContext mappings) {
		wSet(MappingFeatureDescriptorEnum.mappings, mappings);
	}

	public MappingModelContext getDataTypes() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.dataTypes);
	}

	public void setDataTypes(MappingModelContext dataTypes) {
		wSet(MappingFeatureDescriptorEnum.dataTypes, dataTypes);
	}

	public MappingModelContext getName() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.name);
	}

	public void setName(MappingModelContext name) {
		wSet(MappingFeatureDescriptorEnum.name, name);
	}

	public MappingModelContext getEntityType() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.entityType);
	}

	public void setEntityType(MappingModelContext entityType) {
		wSet(MappingFeatureDescriptorEnum.entityType, entityType);
	}

	public MappingModelContext getContextEntityType() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.contextEntityType);
	}

	public void setContextEntityType(MappingModelContext contextEntityType) {
		wSet(MappingFeatureDescriptorEnum.contextEntityType, contextEntityType);
	}

	public MappingModelContext getFeatureType() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.featureType);
	}

	public void setFeatureType(MappingModelContext featureType) {
		wSet(MappingFeatureDescriptorEnum.featureType, featureType);
	}

	public MappingModelContext getUnionTypes() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.unionTypes);
	}

	public void setUnionTypes(MappingModelContext unionTypes) {
		wSet(MappingFeatureDescriptorEnum.unionTypes, unionTypes);
	}

	public MappingModelContext getEnumValues() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.enumValues);
	}

	public void setEnumValues(MappingModelContext enumValues) {
		wSet(MappingFeatureDescriptorEnum.enumValues, enumValues);
	}

	public MappingModelContext getEnumValue() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.enumValue);
	}

	public void setEnumValue(MappingModelContext enumValue) {
		wSet(MappingFeatureDescriptorEnum.enumValue, enumValue);
	}

	public MappingModelContext getValue() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.value);
	}

	public void setValue(MappingModelContext value) {
		wSet(MappingFeatureDescriptorEnum.value, value);
	}

	public MappingModelContext getBuiltInType() {
		return (MappingModelContext) wGet(MappingFeatureDescriptorEnum.builtInType);
	}

	public void setBuiltInType(MappingModelContext builtInType) {
		wSet(MappingFeatureDescriptorEnum.builtInType, builtInType);
	}
}
