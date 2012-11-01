package org.whole.lang.rdb.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class RDBModelContext extends EntityContext {
	public RDBModelContext(IEntity root) {
		super(root);
	}

	public RDBModelContext getUri() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.uri);
	}

	public void setUri(RDBModelContext uri) {
		wSet(RDBFeatureDescriptorEnum.uri, uri);
	}

	public RDBModelContext getNamespace() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.namespace);
	}

	public void setNamespace(RDBModelContext namespace) {
		wSet(RDBFeatureDescriptorEnum.namespace, namespace);
	}

	public RDBModelContext getSchemas() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.schemas);
	}

	public void setSchemas(RDBModelContext schemas) {
		wSet(RDBFeatureDescriptorEnum.schemas, schemas);
	}

	public RDBModelContext getName() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.name);
	}

	public void setName(RDBModelContext name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public RDBModelContext getModelName() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.modelName);
	}

	public void setModelName(RDBModelContext modelName) {
		wSet(RDBFeatureDescriptorEnum.modelName, modelName);
	}

	public RDBModelContext getTables() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.tables);
	}

	public void setTables(RDBModelContext tables) {
		wSet(RDBFeatureDescriptorEnum.tables, tables);
	}

	public RDBModelContext getEntityName() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.entityName);
	}

	public void setEntityName(RDBModelContext entityName) {
		wSet(RDBFeatureDescriptorEnum.entityName, entityName);
	}

	public RDBModelContext getColumns() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.columns);
	}

	public void setColumns(RDBModelContext columns) {
		wSet(RDBFeatureDescriptorEnum.columns, columns);
	}

	public RDBModelContext getPrimaryKey() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.primaryKey);
	}

	public void setPrimaryKey(RDBModelContext primaryKey) {
		wSet(RDBFeatureDescriptorEnum.primaryKey, primaryKey);
	}

	public RDBModelContext getForeignKeys() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.foreignKeys);
	}

	public void setForeignKeys(RDBModelContext foreignKeys) {
		wSet(RDBFeatureDescriptorEnum.foreignKeys, foreignKeys);
	}

	public RDBModelContext getIndices() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.indices);
	}

	public void setIndices(RDBModelContext indices) {
		wSet(RDBFeatureDescriptorEnum.indices, indices);
	}

	public RDBModelContext getRemarks() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.remarks);
	}

	public void setRemarks(RDBModelContext remarks) {
		wSet(RDBFeatureDescriptorEnum.remarks, remarks);
	}

	public RDBModelContext getFeatureName() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.featureName);
	}

	public void setFeatureName(RDBModelContext featureName) {
		wSet(RDBFeatureDescriptorEnum.featureName, featureName);
	}

	public RDBModelContext getFeatureType() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.featureType);
	}

	public void setFeatureType(RDBModelContext featureType) {
		wSet(RDBFeatureDescriptorEnum.featureType, featureType);
	}

	public RDBModelContext getType() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.type);
	}

	public void setType(RDBModelContext type) {
		wSet(RDBFeatureDescriptorEnum.type, type);
	}

	public RDBModelContext getSize() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.size);
	}

	public void setSize(RDBModelContext size) {
		wSet(RDBFeatureDescriptorEnum.size, size);
	}

	public RDBModelContext getDecimals() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.decimals);
	}

	public void setDecimals(RDBModelContext decimals) {
		wSet(RDBFeatureDescriptorEnum.decimals, decimals);
	}

	public RDBModelContext getNullable() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.nullable);
	}

	public void setNullable(RDBModelContext nullable) {
		wSet(RDBFeatureDescriptorEnum.nullable, nullable);
	}

	public RDBModelContext getDefaultValue() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.defaultValue);
	}

	public void setDefaultValue(RDBModelContext defaultValue) {
		wSet(RDBFeatureDescriptorEnum.defaultValue, defaultValue);
	}

	public RDBModelContext getIdMethod() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.idMethod);
	}

	public void setIdMethod(RDBModelContext idMethod) {
		wSet(RDBFeatureDescriptorEnum.idMethod, idMethod);
	}

	public RDBModelContext getColumnNames() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.columnNames);
	}

	public void setColumnNames(RDBModelContext columnNames) {
		wSet(RDBFeatureDescriptorEnum.columnNames, columnNames);
	}

	public RDBModelContext getTargetTable() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.targetTable);
	}

	public void setTargetTable(RDBModelContext targetTable) {
		wSet(RDBFeatureDescriptorEnum.targetTable, targetTable);
	}

	public RDBModelContext getUpdateAction() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.updateAction);
	}

	public void setUpdateAction(RDBModelContext updateAction) {
		wSet(RDBFeatureDescriptorEnum.updateAction, updateAction);
	}

	public RDBModelContext getDeleteAction() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.deleteAction);
	}

	public void setDeleteAction(RDBModelContext deleteAction) {
		wSet(RDBFeatureDescriptorEnum.deleteAction, deleteAction);
	}

	public RDBModelContext getDeferrability() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.deferrability);
	}

	public void setDeferrability(RDBModelContext deferrability) {
		wSet(RDBFeatureDescriptorEnum.deferrability, deferrability);
	}

	public RDBModelContext getColumnReferences() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.columnReferences);
	}

	public void setColumnReferences(RDBModelContext columnReferences) {
		wSet(RDBFeatureDescriptorEnum.columnReferences, columnReferences);
	}

	public RDBModelContext getSource() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.source);
	}

	public void setSource(RDBModelContext source) {
		wSet(RDBFeatureDescriptorEnum.source, source);
	}

	public RDBModelContext getTarget() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.target);
	}

	public void setTarget(RDBModelContext target) {
		wSet(RDBFeatureDescriptorEnum.target, target);
	}

	public RDBModelContext getQualifier() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.qualifier);
	}

	public void setQualifier(RDBModelContext qualifier) {
		wSet(RDBFeatureDescriptorEnum.qualifier, qualifier);
	}

	public RDBModelContext getUnique() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.unique);
	}

	public void setUnique(RDBModelContext unique) {
		wSet(RDBFeatureDescriptorEnum.unique, unique);
	}

	public RDBModelContext getColumnIndices() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.columnIndices);
	}

	public void setColumnIndices(RDBModelContext columnIndices) {
		wSet(RDBFeatureDescriptorEnum.columnIndices, columnIndices);
	}

	public RDBModelContext getOrder() {
		return (RDBModelContext) wGet(RDBFeatureDescriptorEnum.order);
	}

	public void setOrder(RDBModelContext order) {
		wSet(RDBFeatureDescriptorEnum.order, order);
	}
}
