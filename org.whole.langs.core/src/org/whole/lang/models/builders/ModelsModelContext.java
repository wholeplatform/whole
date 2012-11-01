package org.whole.lang.models.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ModelsModelContext extends EntityContext {
	public ModelsModelContext(IEntity root) {
		super(root);
	}

	public ModelsModelContext getName() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.name);
	}

	public void setName(ModelsModelContext name) {
		wSet(ModelsFeatureDescriptorEnum.name, name);
	}

	public ModelsModelContext getTypeRelations() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.typeRelations);
	}

	public void setTypeRelations(ModelsModelContext typeRelations) {
		wSet(ModelsFeatureDescriptorEnum.typeRelations, typeRelations);
	}

	public ModelsModelContext getDeclarations() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.declarations);
	}

	public void setDeclarations(ModelsModelContext declarations) {
		wSet(ModelsFeatureDescriptorEnum.declarations, declarations);
	}

	public ModelsModelContext getNamespace() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.namespace);
	}

	public void setNamespace(ModelsModelContext namespace) {
		wSet(ModelsFeatureDescriptorEnum.namespace, namespace);
	}

	public ModelsModelContext getVersion() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.version);
	}

	public void setVersion(ModelsModelContext version) {
		wSet(ModelsFeatureDescriptorEnum.version, version);
	}

	public ModelsModelContext getUri() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.uri);
	}

	public void setUri(ModelsModelContext uri) {
		wSet(ModelsFeatureDescriptorEnum.uri, uri);
	}

	public ModelsModelContext getModifiers() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.modifiers);
	}

	public void setModifiers(ModelsModelContext modifiers) {
		wSet(ModelsFeatureDescriptorEnum.modifiers, modifiers);
	}

	public ModelsModelContext getTypes() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.types);
	}

	public void setTypes(ModelsModelContext types) {
		wSet(ModelsFeatureDescriptorEnum.types, types);
	}

	public ModelsModelContext getFeatures() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.features);
	}

	public void setFeatures(ModelsModelContext features) {
		wSet(ModelsFeatureDescriptorEnum.features, features);
	}

	public ModelsModelContext getComponentModifiers() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.componentModifiers);
	}

	public void setComponentModifiers(ModelsModelContext componentModifiers) {
		wSet(ModelsFeatureDescriptorEnum.componentModifiers, componentModifiers);
	}

	public ModelsModelContext getComponentType() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.componentType);
	}

	public void setComponentType(ModelsModelContext componentType) {
		wSet(ModelsFeatureDescriptorEnum.componentType, componentType);
	}

	public ModelsModelContext getKeyType() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.keyType);
	}

	public void setKeyType(ModelsModelContext keyType) {
		wSet(ModelsFeatureDescriptorEnum.keyType, keyType);
	}

	public ModelsModelContext getValueType() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.valueType);
	}

	public void setValueType(ModelsModelContext valueType) {
		wSet(ModelsFeatureDescriptorEnum.valueType, valueType);
	}

	public ModelsModelContext getDataType() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.dataType);
	}

	public void setDataType(ModelsModelContext dataType) {
		wSet(ModelsFeatureDescriptorEnum.dataType, dataType);
	}

	public ModelsModelContext getValues() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.values);
	}

	public void setValues(ModelsModelContext values) {
		wSet(ModelsFeatureDescriptorEnum.values, values);
	}

	public ModelsModelContext getType() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.type);
	}

	public void setType(ModelsModelContext type) {
		wSet(ModelsFeatureDescriptorEnum.type, type);
	}

	public ModelsModelContext getOppositeName() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.oppositeName);
	}

	public void setOppositeName(ModelsModelContext oppositeName) {
		wSet(ModelsFeatureDescriptorEnum.oppositeName, oppositeName);
	}

	public ModelsModelContext getForeignType() {
		return (ModelsModelContext) wGet(ModelsFeatureDescriptorEnum.foreignType);
	}

	public void setForeignType(ModelsModelContext foreignType) {
		wSet(ModelsFeatureDescriptorEnum.foreignType, foreignType);
	}
}
