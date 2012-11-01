package org.whole.lang.pojo.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PojoModelContext extends EntityContext {
	public PojoModelContext(IEntity root) {
		super(root);
	}

	public PojoModelContext getAnnotations() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.annotations);
	}

	public void setAnnotations(PojoModelContext annotations) {
		wSet(PojoFeatureDescriptorEnum.annotations, annotations);
	}

	public PojoModelContext getName() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.name);
	}

	public void setName(PojoModelContext name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public PojoModelContext getLanguageURI() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.languageURI);
	}

	public void setLanguageURI(PojoModelContext languageURI) {
		wSet(PojoFeatureDescriptorEnum.languageURI, languageURI);
	}

	public PojoModelContext getDeclarations() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.declarations);
	}

	public void setDeclarations(PojoModelContext declarations) {
		wSet(PojoFeatureDescriptorEnum.declarations, declarations);
	}

	public PojoModelContext getTemplate() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.template);
	}

	public void setTemplate(PojoModelContext template) {
		wSet(PojoFeatureDescriptorEnum.template, template);
	}

	public PojoModelContext getValues() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.values);
	}

	public void setValues(PojoModelContext values) {
		wSet(PojoFeatureDescriptorEnum.values, values);
	}

	public PojoModelContext getProperties() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.properties);
	}

	public void setProperties(PojoModelContext properties) {
		wSet(PojoFeatureDescriptorEnum.properties, properties);
	}

	public PojoModelContext getTypes() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.types);
	}

	public void setTypes(PojoModelContext types) {
		wSet(PojoFeatureDescriptorEnum.types, types);
	}

	public PojoModelContext getConstructors() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.constructors);
	}

	public void setConstructors(PojoModelContext constructors) {
		wSet(PojoFeatureDescriptorEnum.constructors, constructors);
	}

	public PojoModelContext getPrefix() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.prefix);
	}

	public void setPrefix(PojoModelContext prefix) {
		wSet(PojoFeatureDescriptorEnum.prefix, prefix);
	}

	public PojoModelContext getFactoryMethods() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.factoryMethods);
	}

	public void setFactoryMethods(PojoModelContext factoryMethods) {
		wSet(PojoFeatureDescriptorEnum.factoryMethods, factoryMethods);
	}

	public PojoModelContext getProductType() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.productType);
	}

	public void setProductType(PojoModelContext productType) {
		wSet(PojoFeatureDescriptorEnum.productType, productType);
	}

	public PojoModelContext getProductName() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.productName);
	}

	public void setProductName(PojoModelContext productName) {
		wSet(PojoFeatureDescriptorEnum.productName, productName);
	}

	public PojoModelContext getParameters() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.parameters);
	}

	public void setParameters(PojoModelContext parameters) {
		wSet(PojoFeatureDescriptorEnum.parameters, parameters);
	}

	public PojoModelContext getType() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.type);
	}

	public void setType(PojoModelContext type) {
		wSet(PojoFeatureDescriptorEnum.type, type);
	}

	public PojoModelContext getElementType() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.elementType);
	}

	public void setElementType(PojoModelContext elementType) {
		wSet(PojoFeatureDescriptorEnum.elementType, elementType);
	}

	public PojoModelContext getKeyType() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.keyType);
	}

	public void setKeyType(PojoModelContext keyType) {
		wSet(PojoFeatureDescriptorEnum.keyType, keyType);
	}

	public PojoModelContext getValueType() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.valueType);
	}

	public void setValueType(PojoModelContext valueType) {
		wSet(PojoFeatureDescriptorEnum.valueType, valueType);
	}

	public PojoModelContext getCollectionInterface() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.collectionInterface);
	}

	public void setCollectionInterface(PojoModelContext collectionInterface) {
		wSet(PojoFeatureDescriptorEnum.collectionInterface, collectionInterface);
	}

	public PojoModelContext getValue() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.value);
	}

	public void setValue(PojoModelContext value) {
		wSet(PojoFeatureDescriptorEnum.value, value);
	}

	public PojoModelContext getPropertyValuePairs() {
		return (PojoModelContext) wGet(PojoFeatureDescriptorEnum.propertyValuePairs);
	}

	public void setPropertyValuePairs(PojoModelContext propertyValuePairs) {
		wSet(PojoFeatureDescriptorEnum.propertyValuePairs, propertyValuePairs);
	}
}
