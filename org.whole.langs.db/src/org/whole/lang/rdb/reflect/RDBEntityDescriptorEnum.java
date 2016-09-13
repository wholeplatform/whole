package org.whole.lang.rdb.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class RDBEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Database_ord = 0;
	public static final int Schemas_ord = 1;
	public static final int Schema_ord = 2;
	public static final int Tables_ord = 3;
	public static final int Table_ord = 4;
	public static final int Columns_ord = 5;
	public static final int Column_ord = 6;
	public static final int PrimaryKey_ord = 7;
	public static final int ColumnNames_ord = 8;
	public static final int ForeignKeys_ord = 9;
	public static final int ForeignKey_ord = 10;
	public static final int ColumnReferences_ord = 11;
	public static final int ColumnReference_ord = 12;
	public static final int Indices_ord = 13;
	public static final int Index_ord = 14;
	public static final int ColumnIndices_ord = 15;
	public static final int ColumnIndex_ord = 16;
	public static final int Type_ord = 17;
	public static final int IndexType_ord = 18;
	public static final int Order_ord = 19;
	public static final int IdMethod_ord = 20;
	public static final int Action_ord = 21;
	public static final int Deferrability_ord = 22;
	public static final int URI_ord = 23;
	public static final int Namespace_ord = 24;
	public static final int Name_ord = 25;
	public static final int StringData_ord = 26;
	public static final int IntData_ord = 27;
	public static final int BooleanData_ord = 28;
	public static final RDBEntityDescriptorEnum instance = new RDBEntityDescriptorEnum();
	public static final EntityDescriptor<Database> Database = (EntityDescriptor<Database>) instance
			.valueOf(Database_ord);
	public static final EntityDescriptor<Schemas> Schemas = (EntityDescriptor<Schemas>) instance
			.valueOf(Schemas_ord);
	public static final EntityDescriptor<Schema> Schema = (EntityDescriptor<Schema>) instance
			.valueOf(Schema_ord);
	public static final EntityDescriptor<Tables> Tables = (EntityDescriptor<Tables>) instance
			.valueOf(Tables_ord);
	public static final EntityDescriptor<Table> Table = (EntityDescriptor<Table>) instance
			.valueOf(Table_ord);
	public static final EntityDescriptor<Columns> Columns = (EntityDescriptor<Columns>) instance
			.valueOf(Columns_ord);
	public static final EntityDescriptor<Column> Column = (EntityDescriptor<Column>) instance
			.valueOf(Column_ord);
	public static final EntityDescriptor<PrimaryKey> PrimaryKey = (EntityDescriptor<PrimaryKey>) instance
			.valueOf(PrimaryKey_ord);
	public static final EntityDescriptor<ColumnNames> ColumnNames = (EntityDescriptor<ColumnNames>) instance
			.valueOf(ColumnNames_ord);
	public static final EntityDescriptor<ForeignKeys> ForeignKeys = (EntityDescriptor<ForeignKeys>) instance
			.valueOf(ForeignKeys_ord);
	public static final EntityDescriptor<ForeignKey> ForeignKey = (EntityDescriptor<ForeignKey>) instance
			.valueOf(ForeignKey_ord);
	public static final EntityDescriptor<ColumnReferences> ColumnReferences = (EntityDescriptor<ColumnReferences>) instance
			.valueOf(ColumnReferences_ord);
	public static final EntityDescriptor<ColumnReference> ColumnReference = (EntityDescriptor<ColumnReference>) instance
			.valueOf(ColumnReference_ord);
	public static final EntityDescriptor<Indices> Indices = (EntityDescriptor<Indices>) instance
			.valueOf(Indices_ord);
	public static final EntityDescriptor<Index> Index = (EntityDescriptor<Index>) instance
			.valueOf(Index_ord);
	public static final EntityDescriptor<ColumnIndices> ColumnIndices = (EntityDescriptor<ColumnIndices>) instance
			.valueOf(ColumnIndices_ord);
	public static final EntityDescriptor<ColumnIndex> ColumnIndex = (EntityDescriptor<ColumnIndex>) instance
			.valueOf(ColumnIndex_ord);
	public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance
			.valueOf(Type_ord);
	public static final EntityDescriptor<IndexType> IndexType = (EntityDescriptor<IndexType>) instance
			.valueOf(IndexType_ord);
	public static final EntityDescriptor<Order> Order = (EntityDescriptor<Order>) instance
			.valueOf(Order_ord);
	public static final EntityDescriptor<IdMethod> IdMethod = (EntityDescriptor<IdMethod>) instance
			.valueOf(IdMethod_ord);
	public static final EntityDescriptor<Action> Action = (EntityDescriptor<Action>) instance
			.valueOf(Action_ord);
	public static final EntityDescriptor<Deferrability> Deferrability = (EntityDescriptor<Deferrability>) instance
			.valueOf(Deferrability_ord);
	public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance
			.valueOf(URI_ord);
	public static final EntityDescriptor<Namespace> Namespace = (EntityDescriptor<Namespace>) instance
			.valueOf(Namespace_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<StringData> StringData = (EntityDescriptor<StringData>) instance
			.valueOf(StringData_ord);
	public static final EntityDescriptor<IntData> IntData = (EntityDescriptor<IntData>) instance
			.valueOf(IntData_ord);
	public static final EntityDescriptor<BooleanData> BooleanData = (EntityDescriptor<BooleanData>) instance
			.valueOf(BooleanData_ord);

	private RDBEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Database_ord, "Database", Database.class, false)
				.withFeature(RDBFeatureDescriptorEnum.uri, URI_ord)
				.withFeature(RDBFeatureDescriptorEnum.namespace, Namespace_ord)
				.withFeature(RDBFeatureDescriptorEnum.schemas, Schemas_ord);
		putCompositeEntity(
		Schemas_ord, "Schemas", Schemas.class, false, Schema_ord, false, true);
		putSimpleEntity(Schema_ord, "Schema", Schema.class, false)
				.withFeature(RDBFeatureDescriptorEnum.name, StringData_ord,
						true, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.modelName,
						StringData_ord, true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.tables, Tables_ord, true,
						false, false, false, false);
		putCompositeEntity(
		Tables_ord, "Tables", Tables.class, false, Table_ord, false, true);
		putSimpleEntity(Table_ord, "Table", Table.class, false)
				.withFeature(RDBFeatureDescriptorEnum.name, StringData_ord,
						false, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.entityName, Name_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.columns, Columns_ord)
				.withFeature(RDBFeatureDescriptorEnum.primaryKey,
						PrimaryKey_ord, true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.foreignKeys,
						ForeignKeys_ord, true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.indices, Indices_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.remarks, StringData_ord,
						true, false, false, false, false);
		putCompositeEntity(
		Columns_ord, "Columns", Columns.class, false, Column_ord, true, true);
		putSimpleEntity(Column_ord, "Column", Column.class, false)
				.withFeature(RDBFeatureDescriptorEnum.name, StringData_ord,
						false, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.featureName, Name_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.featureType, Name_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.type, Type_ord)
				.withFeature(RDBFeatureDescriptorEnum.size, IntData_ord, true,
						false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.decimals, IntData_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.nullable,
						BooleanData_ord, true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.defaultValue,
						StringData_ord, true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.remarks, StringData_ord,
						true, false, false, false, false);
		putSimpleEntity(PrimaryKey_ord, "PrimaryKey", PrimaryKey.class, false)
				.withFeature(RDBFeatureDescriptorEnum.name, StringData_ord,
						true, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.idMethod, IdMethod_ord)
				.withFeature(RDBFeatureDescriptorEnum.columnNames,
						ColumnNames_ord);
		putCompositeEntity(
		ColumnNames_ord, "ColumnNames", ColumnNames.class, false, StringData_ord, true, true);
		putCompositeEntity(
		ForeignKeys_ord, "ForeignKeys", ForeignKeys.class, false, ForeignKey_ord, true, false);
		putSimpleEntity(ForeignKey_ord, "ForeignKey", ForeignKey.class, false)
				.withFeature(RDBFeatureDescriptorEnum.name, StringData_ord,
						true, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.targetTable,
						StringData_ord)
				.withFeature(RDBFeatureDescriptorEnum.updateAction, Action_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.deleteAction, Action_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.deferrability,
						Deferrability_ord, true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.columnReferences,
						ColumnReferences_ord);
		putCompositeEntity(
		ColumnReferences_ord, "ColumnReferences", ColumnReferences.class, false, ColumnReference_ord, true, false);
		putSimpleEntity(ColumnReference_ord, "ColumnReference",
				ColumnReference.class, false).withFeature(
				RDBFeatureDescriptorEnum.source, StringData_ord).withFeature(
				RDBFeatureDescriptorEnum.target, StringData_ord);
		putCompositeEntity(
		Indices_ord, "Indices", Indices.class, false, Index_ord, true, false);
		putSimpleEntity(Index_ord, "Index", Index.class, false)
				.withFeature(RDBFeatureDescriptorEnum.name, StringData_ord,
						false, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.qualifier,
						StringData_ord, true, true, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.unique, BooleanData_ord)
				.withFeature(RDBFeatureDescriptorEnum.type, IndexType_ord,
						true, false, false, false, false)
				.withFeature(RDBFeatureDescriptorEnum.columnIndices,
						ColumnIndices_ord);
		putCompositeEntity(
		ColumnIndices_ord, "ColumnIndices", ColumnIndices.class, false, ColumnIndex_ord, true, true);
		putSimpleEntity(ColumnIndex_ord, "ColumnIndex", ColumnIndex.class,
				false).withFeature(RDBFeatureDescriptorEnum.name,
				StringData_ord, false, true, false, false, false).withFeature(
				RDBFeatureDescriptorEnum.order, Order_ord);
		putDataEntity(Type_ord, "Type", Type.class, false, TypeEnum.Value.class);
		putDataEntity(IndexType_ord, "IndexType", IndexType.class, false,
				IndexTypeEnum.Value.class);
		putDataEntity(Order_ord, "Order", Order.class, false,
				OrderEnum.Value.class);
		putDataEntity(IdMethod_ord, "IdMethod", IdMethod.class, false,
				IdMethodEnum.Value.class);
		putDataEntity(Action_ord, "Action", Action.class, false,
				ActionEnum.Value.class);
		putDataEntity(Deferrability_ord, "Deferrability", Deferrability.class,
				false, DeferrabilityEnum.Value.class);
		putDataEntity(URI_ord, "URI", URI.class, false, String.class);
		putDataEntity(Namespace_ord, "Namespace", Namespace.class, false,
				String.class);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putDataEntity(StringData_ord, "StringData", StringData.class, false,
				String.class);
		putDataEntity(IntData_ord, "IntData", IntData.class, false, int.class);
		putDataEntity(BooleanData_ord, "BooleanData", BooleanData.class, false,
				boolean.class);
	}
}
