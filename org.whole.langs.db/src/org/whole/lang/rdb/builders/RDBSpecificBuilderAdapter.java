package org.whole.lang.rdb.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.model.TypeEnum;
import org.whole.lang.rdb.model.IndexTypeEnum;
import org.whole.lang.rdb.model.OrderEnum;
import org.whole.lang.rdb.model.IdMethodEnum;
import org.whole.lang.rdb.model.ActionEnum;
import org.whole.lang.rdb.model.DeferrabilityEnum;

/** 
 * @generator Whole
 */
public class RDBSpecificBuilderAdapter extends GenericBuilderContext implements
		IRDBBuilder {
	public RDBSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public RDBSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void order() {
		wFeature(RDBFeatureDescriptorEnum.order);
	}

	public void columnIndices() {
		wFeature(RDBFeatureDescriptorEnum.columnIndices);
	}

	public void unique() {
		wFeature(RDBFeatureDescriptorEnum.unique);
	}

	public void qualifier() {
		wFeature(RDBFeatureDescriptorEnum.qualifier);
	}

	public void target() {
		wFeature(RDBFeatureDescriptorEnum.target);
	}

	public void source() {
		wFeature(RDBFeatureDescriptorEnum.source);
	}

	public void columnReferences() {
		wFeature(RDBFeatureDescriptorEnum.columnReferences);
	}

	public void deferrability() {
		wFeature(RDBFeatureDescriptorEnum.deferrability);
	}

	public void deleteAction() {
		wFeature(RDBFeatureDescriptorEnum.deleteAction);
	}

	public void updateAction() {
		wFeature(RDBFeatureDescriptorEnum.updateAction);
	}

	public void targetTable() {
		wFeature(RDBFeatureDescriptorEnum.targetTable);
	}

	public void columnNames() {
		wFeature(RDBFeatureDescriptorEnum.columnNames);
	}

	public void idMethod() {
		wFeature(RDBFeatureDescriptorEnum.idMethod);
	}

	public void defaultValue() {
		wFeature(RDBFeatureDescriptorEnum.defaultValue);
	}

	public void nullable() {
		wFeature(RDBFeatureDescriptorEnum.nullable);
	}

	public void decimals() {
		wFeature(RDBFeatureDescriptorEnum.decimals);
	}

	public void size() {
		wFeature(RDBFeatureDescriptorEnum.size);
	}

	public void type() {
		wFeature(RDBFeatureDescriptorEnum.type);
	}

	public void featureType() {
		wFeature(RDBFeatureDescriptorEnum.featureType);
	}

	public void featureName() {
		wFeature(RDBFeatureDescriptorEnum.featureName);
	}

	public void remarks() {
		wFeature(RDBFeatureDescriptorEnum.remarks);
	}

	public void indices() {
		wFeature(RDBFeatureDescriptorEnum.indices);
	}

	public void foreignKeys() {
		wFeature(RDBFeatureDescriptorEnum.foreignKeys);
	}

	public void primaryKey() {
		wFeature(RDBFeatureDescriptorEnum.primaryKey);
	}

	public void columns() {
		wFeature(RDBFeatureDescriptorEnum.columns);
	}

	public void entityName() {
		wFeature(RDBFeatureDescriptorEnum.entityName);
	}

	public void tables() {
		wFeature(RDBFeatureDescriptorEnum.tables);
	}

	public void modelName() {
		wFeature(RDBFeatureDescriptorEnum.modelName);
	}

	public void name() {
		wFeature(RDBFeatureDescriptorEnum.name);
	}

	public void schemas() {
		wFeature(RDBFeatureDescriptorEnum.schemas);
	}

	public void namespace() {
		wFeature(RDBFeatureDescriptorEnum.namespace);
	}

	public void uri() {
		wFeature(RDBFeatureDescriptorEnum.uri);
	}

	public void visit() {
	}

	public void Database() {
		wEntity(RDBEntityDescriptorEnum.Database);
	}

	public void Database_() {
		wEntity_(RDBEntityDescriptorEnum.Database);
	}

	public void _Database() {
		_wEntity(RDBEntityDescriptorEnum.Database);
	}

	public void Schemas() {
		wEntity(RDBEntityDescriptorEnum.Schemas);
	}

	public void Schemas_() {
		wEntity_(RDBEntityDescriptorEnum.Schemas);
	}

	public void Schemas_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.Schemas, initialCapacity);
	}

	public void _Schemas() {
		_wEntity(RDBEntityDescriptorEnum.Schemas);
	}

	public void Schema() {
		wEntity(RDBEntityDescriptorEnum.Schema);
	}

	public void Schema_() {
		wEntity_(RDBEntityDescriptorEnum.Schema);
	}

	public void _Schema() {
		_wEntity(RDBEntityDescriptorEnum.Schema);
	}

	public void Tables() {
		wEntity(RDBEntityDescriptorEnum.Tables);
	}

	public void Tables_() {
		wEntity_(RDBEntityDescriptorEnum.Tables);
	}

	public void Tables_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.Tables, initialCapacity);
	}

	public void _Tables() {
		_wEntity(RDBEntityDescriptorEnum.Tables);
	}

	public void Table() {
		wEntity(RDBEntityDescriptorEnum.Table);
	}

	public void Table_() {
		wEntity_(RDBEntityDescriptorEnum.Table);
	}

	public void _Table() {
		_wEntity(RDBEntityDescriptorEnum.Table);
	}

	public void Columns() {
		wEntity(RDBEntityDescriptorEnum.Columns);
	}

	public void Columns_() {
		wEntity_(RDBEntityDescriptorEnum.Columns);
	}

	public void Columns_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.Columns, initialCapacity);
	}

	public void _Columns() {
		_wEntity(RDBEntityDescriptorEnum.Columns);
	}

	public void Column() {
		wEntity(RDBEntityDescriptorEnum.Column);
	}

	public void Column_() {
		wEntity_(RDBEntityDescriptorEnum.Column);
	}

	public void _Column() {
		_wEntity(RDBEntityDescriptorEnum.Column);
	}

	public void PrimaryKey() {
		wEntity(RDBEntityDescriptorEnum.PrimaryKey);
	}

	public void PrimaryKey_() {
		wEntity_(RDBEntityDescriptorEnum.PrimaryKey);
	}

	public void _PrimaryKey() {
		_wEntity(RDBEntityDescriptorEnum.PrimaryKey);
	}

	public void ColumnNames() {
		wEntity(RDBEntityDescriptorEnum.ColumnNames);
	}

	public void ColumnNames_() {
		wEntity_(RDBEntityDescriptorEnum.ColumnNames);
	}

	public void ColumnNames_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.ColumnNames, initialCapacity);
	}

	public void _ColumnNames() {
		_wEntity(RDBEntityDescriptorEnum.ColumnNames);
	}

	public void ForeignKeys() {
		wEntity(RDBEntityDescriptorEnum.ForeignKeys);
	}

	public void ForeignKeys_() {
		wEntity_(RDBEntityDescriptorEnum.ForeignKeys);
	}

	public void ForeignKeys_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.ForeignKeys, initialCapacity);
	}

	public void _ForeignKeys() {
		_wEntity(RDBEntityDescriptorEnum.ForeignKeys);
	}

	public void ForeignKey() {
		wEntity(RDBEntityDescriptorEnum.ForeignKey);
	}

	public void ForeignKey_() {
		wEntity_(RDBEntityDescriptorEnum.ForeignKey);
	}

	public void _ForeignKey() {
		_wEntity(RDBEntityDescriptorEnum.ForeignKey);
	}

	public void ColumnReferences() {
		wEntity(RDBEntityDescriptorEnum.ColumnReferences);
	}

	public void ColumnReferences_() {
		wEntity_(RDBEntityDescriptorEnum.ColumnReferences);
	}

	public void ColumnReferences_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.ColumnReferences, initialCapacity);
	}

	public void _ColumnReferences() {
		_wEntity(RDBEntityDescriptorEnum.ColumnReferences);
	}

	public void ColumnReference() {
		wEntity(RDBEntityDescriptorEnum.ColumnReference);
	}

	public void ColumnReference_() {
		wEntity_(RDBEntityDescriptorEnum.ColumnReference);
	}

	public void _ColumnReference() {
		_wEntity(RDBEntityDescriptorEnum.ColumnReference);
	}

	public void Indices() {
		wEntity(RDBEntityDescriptorEnum.Indices);
	}

	public void Indices_() {
		wEntity_(RDBEntityDescriptorEnum.Indices);
	}

	public void Indices_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.Indices, initialCapacity);
	}

	public void _Indices() {
		_wEntity(RDBEntityDescriptorEnum.Indices);
	}

	public void Index() {
		wEntity(RDBEntityDescriptorEnum.Index);
	}

	public void Index_() {
		wEntity_(RDBEntityDescriptorEnum.Index);
	}

	public void _Index() {
		_wEntity(RDBEntityDescriptorEnum.Index);
	}

	public void ColumnIndices() {
		wEntity(RDBEntityDescriptorEnum.ColumnIndices);
	}

	public void ColumnIndices_() {
		wEntity_(RDBEntityDescriptorEnum.ColumnIndices);
	}

	public void ColumnIndices_(int initialCapacity) {
		wEntity_(RDBEntityDescriptorEnum.ColumnIndices, initialCapacity);
	}

	public void _ColumnIndices() {
		_wEntity(RDBEntityDescriptorEnum.ColumnIndices);
	}

	public void ColumnIndex() {
		wEntity(RDBEntityDescriptorEnum.ColumnIndex);
	}

	public void ColumnIndex_() {
		wEntity_(RDBEntityDescriptorEnum.ColumnIndex);
	}

	public void _ColumnIndex() {
		_wEntity(RDBEntityDescriptorEnum.ColumnIndex);
	}

	public void Type() {
		wEntity(RDBEntityDescriptorEnum.Type);
	}

	public void Type(TypeEnum.Value value) {
		wEntity(RDBEntityDescriptorEnum.Type, value);
	}

	public void Type(String value) {
		wEntity(RDBEntityDescriptorEnum.Type, value);
	}

	public void IndexType() {
		wEntity(RDBEntityDescriptorEnum.IndexType);
	}

	public void IndexType(IndexTypeEnum.Value value) {
		wEntity(RDBEntityDescriptorEnum.IndexType, value);
	}

	public void IndexType(String value) {
		wEntity(RDBEntityDescriptorEnum.IndexType, value);
	}

	public void Order() {
		wEntity(RDBEntityDescriptorEnum.Order);
	}

	public void Order(OrderEnum.Value value) {
		wEntity(RDBEntityDescriptorEnum.Order, value);
	}

	public void Order(String value) {
		wEntity(RDBEntityDescriptorEnum.Order, value);
	}

	public void IdMethod() {
		wEntity(RDBEntityDescriptorEnum.IdMethod);
	}

	public void IdMethod(IdMethodEnum.Value value) {
		wEntity(RDBEntityDescriptorEnum.IdMethod, value);
	}

	public void IdMethod(String value) {
		wEntity(RDBEntityDescriptorEnum.IdMethod, value);
	}

	public void Action() {
		wEntity(RDBEntityDescriptorEnum.Action);
	}

	public void Action(ActionEnum.Value value) {
		wEntity(RDBEntityDescriptorEnum.Action, value);
	}

	public void Action(String value) {
		wEntity(RDBEntityDescriptorEnum.Action, value);
	}

	public void Deferrability() {
		wEntity(RDBEntityDescriptorEnum.Deferrability);
	}

	public void Deferrability(DeferrabilityEnum.Value value) {
		wEntity(RDBEntityDescriptorEnum.Deferrability, value);
	}

	public void Deferrability(String value) {
		wEntity(RDBEntityDescriptorEnum.Deferrability, value);
	}

	public void URI() {
		wEntity(RDBEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(RDBEntityDescriptorEnum.URI, value);
	}

	public void Namespace() {
		wEntity(RDBEntityDescriptorEnum.Namespace);
	}

	public void Namespace(String value) {
		wEntity(RDBEntityDescriptorEnum.Namespace, value);
	}

	public void Name() {
		wEntity(RDBEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(RDBEntityDescriptorEnum.Name, value);
	}

	public void StringData() {
		wEntity(RDBEntityDescriptorEnum.StringData);
	}

	public void StringData(String value) {
		wEntity(RDBEntityDescriptorEnum.StringData, value);
	}

	public void IntData() {
		wEntity(RDBEntityDescriptorEnum.IntData);
	}

	public void IntData(int value) {
		wEntity(RDBEntityDescriptorEnum.IntData, value);
	}

	public void BooleanData() {
		wEntity(RDBEntityDescriptorEnum.BooleanData);
	}

	public void BooleanData(boolean value) {
		wEntity(RDBEntityDescriptorEnum.BooleanData, value);
	}
}
