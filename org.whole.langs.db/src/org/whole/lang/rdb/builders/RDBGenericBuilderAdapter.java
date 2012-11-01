package org.whole.lang.rdb.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.rdb.model.TypeEnum.Value;

/** 
 * @generator Whole
 */
public class RDBGenericBuilderAdapter extends GenericIdentityBuilder {
	private IRDBBuilder specificBuilder;

	public RDBGenericBuilderAdapter(IRDBBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public RDBGenericBuilderAdapter(IRDBBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case RDBFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		case RDBFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case RDBFeatureDescriptorEnum.schemas_ord:
			specificBuilder.schemas();
			break;
		case RDBFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case RDBFeatureDescriptorEnum.modelName_ord:
			specificBuilder.modelName();
			break;
		case RDBFeatureDescriptorEnum.tables_ord:
			specificBuilder.tables();
			break;
		case RDBFeatureDescriptorEnum.entityName_ord:
			specificBuilder.entityName();
			break;
		case RDBFeatureDescriptorEnum.columns_ord:
			specificBuilder.columns();
			break;
		case RDBFeatureDescriptorEnum.primaryKey_ord:
			specificBuilder.primaryKey();
			break;
		case RDBFeatureDescriptorEnum.foreignKeys_ord:
			specificBuilder.foreignKeys();
			break;
		case RDBFeatureDescriptorEnum.indices_ord:
			specificBuilder.indices();
			break;
		case RDBFeatureDescriptorEnum.remarks_ord:
			specificBuilder.remarks();
			break;
		case RDBFeatureDescriptorEnum.featureName_ord:
			specificBuilder.featureName();
			break;
		case RDBFeatureDescriptorEnum.featureType_ord:
			specificBuilder.featureType();
			break;
		case RDBFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case RDBFeatureDescriptorEnum.size_ord:
			specificBuilder.size();
			break;
		case RDBFeatureDescriptorEnum.decimals_ord:
			specificBuilder.decimals();
			break;
		case RDBFeatureDescriptorEnum.nullable_ord:
			specificBuilder.nullable();
			break;
		case RDBFeatureDescriptorEnum.defaultValue_ord:
			specificBuilder.defaultValue();
			break;
		case RDBFeatureDescriptorEnum.idMethod_ord:
			specificBuilder.idMethod();
			break;
		case RDBFeatureDescriptorEnum.columnNames_ord:
			specificBuilder.columnNames();
			break;
		case RDBFeatureDescriptorEnum.targetTable_ord:
			specificBuilder.targetTable();
			break;
		case RDBFeatureDescriptorEnum.updateAction_ord:
			specificBuilder.updateAction();
			break;
		case RDBFeatureDescriptorEnum.deleteAction_ord:
			specificBuilder.deleteAction();
			break;
		case RDBFeatureDescriptorEnum.deferrability_ord:
			specificBuilder.deferrability();
			break;
		case RDBFeatureDescriptorEnum.columnReferences_ord:
			specificBuilder.columnReferences();
			break;
		case RDBFeatureDescriptorEnum.source_ord:
			specificBuilder.source();
			break;
		case RDBFeatureDescriptorEnum.target_ord:
			specificBuilder.target();
			break;
		case RDBFeatureDescriptorEnum.qualifier_ord:
			specificBuilder.qualifier();
			break;
		case RDBFeatureDescriptorEnum.unique_ord:
			specificBuilder.unique();
			break;
		case RDBFeatureDescriptorEnum.columnIndices_ord:
			specificBuilder.columnIndices();
			break;
		case RDBFeatureDescriptorEnum.order_ord:
			specificBuilder.order();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.Database_ord:
			specificBuilder.Database();
			break;
		case RDBEntityDescriptorEnum.Schemas_ord:
			specificBuilder.Schemas();
			break;
		case RDBEntityDescriptorEnum.Schema_ord:
			specificBuilder.Schema();
			break;
		case RDBEntityDescriptorEnum.Tables_ord:
			specificBuilder.Tables();
			break;
		case RDBEntityDescriptorEnum.Table_ord:
			specificBuilder.Table();
			break;
		case RDBEntityDescriptorEnum.Columns_ord:
			specificBuilder.Columns();
			break;
		case RDBEntityDescriptorEnum.Column_ord:
			specificBuilder.Column();
			break;
		case RDBEntityDescriptorEnum.PrimaryKey_ord:
			specificBuilder.PrimaryKey();
			break;
		case RDBEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder.ColumnNames();
			break;
		case RDBEntityDescriptorEnum.ForeignKeys_ord:
			specificBuilder.ForeignKeys();
			break;
		case RDBEntityDescriptorEnum.ForeignKey_ord:
			specificBuilder.ForeignKey();
			break;
		case RDBEntityDescriptorEnum.ColumnReferences_ord:
			specificBuilder.ColumnReferences();
			break;
		case RDBEntityDescriptorEnum.ColumnReference_ord:
			specificBuilder.ColumnReference();
			break;
		case RDBEntityDescriptorEnum.Indices_ord:
			specificBuilder.Indices();
			break;
		case RDBEntityDescriptorEnum.Index_ord:
			specificBuilder.Index();
			break;
		case RDBEntityDescriptorEnum.ColumnIndices_ord:
			specificBuilder.ColumnIndices();
			break;
		case RDBEntityDescriptorEnum.ColumnIndex_ord:
			specificBuilder.ColumnIndex();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.Database_ord:
			specificBuilder.Database_();
			break;
		case RDBEntityDescriptorEnum.Schemas_ord:
			specificBuilder.Schemas_();
			break;
		case RDBEntityDescriptorEnum.Schema_ord:
			specificBuilder.Schema_();
			break;
		case RDBEntityDescriptorEnum.Tables_ord:
			specificBuilder.Tables_();
			break;
		case RDBEntityDescriptorEnum.Table_ord:
			specificBuilder.Table_();
			break;
		case RDBEntityDescriptorEnum.Columns_ord:
			specificBuilder.Columns_();
			break;
		case RDBEntityDescriptorEnum.Column_ord:
			specificBuilder.Column_();
			break;
		case RDBEntityDescriptorEnum.PrimaryKey_ord:
			specificBuilder.PrimaryKey_();
			break;
		case RDBEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder.ColumnNames_();
			break;
		case RDBEntityDescriptorEnum.ForeignKeys_ord:
			specificBuilder.ForeignKeys_();
			break;
		case RDBEntityDescriptorEnum.ForeignKey_ord:
			specificBuilder.ForeignKey_();
			break;
		case RDBEntityDescriptorEnum.ColumnReferences_ord:
			specificBuilder.ColumnReferences_();
			break;
		case RDBEntityDescriptorEnum.ColumnReference_ord:
			specificBuilder.ColumnReference_();
			break;
		case RDBEntityDescriptorEnum.Indices_ord:
			specificBuilder.Indices_();
			break;
		case RDBEntityDescriptorEnum.Index_ord:
			specificBuilder.Index_();
			break;
		case RDBEntityDescriptorEnum.ColumnIndices_ord:
			specificBuilder.ColumnIndices_();
			break;
		case RDBEntityDescriptorEnum.ColumnIndex_ord:
			specificBuilder.ColumnIndex_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.Database_ord:
			specificBuilder._Database();
			break;
		case RDBEntityDescriptorEnum.Schemas_ord:
			specificBuilder._Schemas();
			break;
		case RDBEntityDescriptorEnum.Schema_ord:
			specificBuilder._Schema();
			break;
		case RDBEntityDescriptorEnum.Tables_ord:
			specificBuilder._Tables();
			break;
		case RDBEntityDescriptorEnum.Table_ord:
			specificBuilder._Table();
			break;
		case RDBEntityDescriptorEnum.Columns_ord:
			specificBuilder._Columns();
			break;
		case RDBEntityDescriptorEnum.Column_ord:
			specificBuilder._Column();
			break;
		case RDBEntityDescriptorEnum.PrimaryKey_ord:
			specificBuilder._PrimaryKey();
			break;
		case RDBEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder._ColumnNames();
			break;
		case RDBEntityDescriptorEnum.ForeignKeys_ord:
			specificBuilder._ForeignKeys();
			break;
		case RDBEntityDescriptorEnum.ForeignKey_ord:
			specificBuilder._ForeignKey();
			break;
		case RDBEntityDescriptorEnum.ColumnReferences_ord:
			specificBuilder._ColumnReferences();
			break;
		case RDBEntityDescriptorEnum.ColumnReference_ord:
			specificBuilder._ColumnReference();
			break;
		case RDBEntityDescriptorEnum.Indices_ord:
			specificBuilder._Indices();
			break;
		case RDBEntityDescriptorEnum.Index_ord:
			specificBuilder._Index();
			break;
		case RDBEntityDescriptorEnum.ColumnIndices_ord:
			specificBuilder._ColumnIndices();
			break;
		case RDBEntityDescriptorEnum.ColumnIndex_ord:
			specificBuilder._ColumnIndex();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.Schemas_ord:
			specificBuilder.Schemas_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.Tables_ord:
			specificBuilder.Tables_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.Columns_ord:
			specificBuilder.Columns_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder.ColumnNames_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.ForeignKeys_ord:
			specificBuilder.ForeignKeys_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.ColumnReferences_ord:
			specificBuilder.ColumnReferences_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.Indices_ord:
			specificBuilder.Indices_(initialCapacity);
			break;
		case RDBEntityDescriptorEnum.ColumnIndices_ord:
			specificBuilder.ColumnIndices_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.Type_ord:
			specificBuilder.Type((Value) value);
			break;
		case RDBEntityDescriptorEnum.IndexType_ord:
			specificBuilder
					.IndexType((org.whole.lang.rdb.model.IndexTypeEnum.Value) value);
			break;
		case RDBEntityDescriptorEnum.Order_ord:
			specificBuilder
					.Order((org.whole.lang.rdb.model.OrderEnum.Value) value);
			break;
		case RDBEntityDescriptorEnum.IdMethod_ord:
			specificBuilder
					.IdMethod((org.whole.lang.rdb.model.IdMethodEnum.Value) value);
			break;
		case RDBEntityDescriptorEnum.Action_ord:
			specificBuilder
					.Action((org.whole.lang.rdb.model.ActionEnum.Value) value);
			break;
		case RDBEntityDescriptorEnum.Deferrability_ord:
			specificBuilder
					.Deferrability((org.whole.lang.rdb.model.DeferrabilityEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		case RDBEntityDescriptorEnum.Namespace_ord:
			specificBuilder.Namespace(value);
			break;
		case RDBEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case RDBEntityDescriptorEnum.StringData_ord:
			specificBuilder.StringData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.IntData_ord:
			specificBuilder.IntData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case RDBEntityDescriptorEnum.BooleanData_ord:
			specificBuilder.BooleanData(value);
			break;
		}
	}
}
