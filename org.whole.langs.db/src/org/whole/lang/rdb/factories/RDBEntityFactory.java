package org.whole.lang.rdb.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.rdb.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RDBEntityFactory extends GenericEntityFactory {
	public static final RDBEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static RDBEntityFactory instance(IEntityRegistryProvider provider) {
		return new RDBEntityFactory(provider);
	}

	protected RDBEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Database createDatabase() {
		return create(RDBEntityDescriptorEnum.Database);
	}

	public Database createDatabase(URI uri, Namespace namespace, Schemas schemas) {
		return create(RDBEntityDescriptorEnum.Database, uri, namespace, schemas);
	}

	public IEntityBuilder<Database> buildDatabase() {
		return new EntityBuilder<Database>(
				create(RDBEntityDescriptorEnum.Database));
	}

	public Schemas createSchemas() {
		return create(RDBEntityDescriptorEnum.Schemas);
	}

	public Schemas createSchemas(Schema... entities) {
		return create(RDBEntityDescriptorEnum.Schemas, (IEntity[]) entities);
	}

	public Schemas createSchemas(int initialSize) {
		return clone(RDBEntityDescriptorEnum.Schemas, initialSize);
	}

	public Schema createSchema() {
		return create(RDBEntityDescriptorEnum.Schema);
	}

	public Schema createSchema(StringData name, StringData modelName,
			Tables tables) {
		return create(RDBEntityDescriptorEnum.Schema, name, modelName, tables);
	}

	public IEntityBuilder<Schema> buildSchema() {
		return new EntityBuilder<Schema>(create(RDBEntityDescriptorEnum.Schema));
	}

	public Tables createTables() {
		return create(RDBEntityDescriptorEnum.Tables);
	}

	public Tables createTables(Table... entities) {
		return create(RDBEntityDescriptorEnum.Tables, (IEntity[]) entities);
	}

	public Tables createTables(int initialSize) {
		return clone(RDBEntityDescriptorEnum.Tables, initialSize);
	}

	public Table createTable() {
		return create(RDBEntityDescriptorEnum.Table);
	}

	public Table createTable(StringData name, Name entityName, Columns columns,
			PrimaryKey primaryKey, ForeignKeys foreignKeys, Indices indices,
			StringData remarks) {
		return create(RDBEntityDescriptorEnum.Table, name, entityName, columns,
				primaryKey, foreignKeys, indices, remarks);
	}

	public IEntityBuilder<Table> buildTable() {
		return new EntityBuilder<Table>(create(RDBEntityDescriptorEnum.Table));
	}

	public Columns createColumns() {
		return create(RDBEntityDescriptorEnum.Columns);
	}

	public Columns createColumns(Column... entities) {
		return create(RDBEntityDescriptorEnum.Columns, (IEntity[]) entities);
	}

	public Columns createColumns(int initialSize) {
		return clone(RDBEntityDescriptorEnum.Columns, initialSize);
	}

	public Column createColumn() {
		return create(RDBEntityDescriptorEnum.Column);
	}

	public Column createColumn(StringData name, Name featureName,
			Name featureType, Type type, IntData size, IntData decimals,
			BooleanData nullable, StringData defaultValue, StringData remarks) {
		return create(RDBEntityDescriptorEnum.Column, name, featureName,
				featureType, type, size, decimals, nullable, defaultValue,
				remarks);
	}

	public IEntityBuilder<Column> buildColumn() {
		return new EntityBuilder<Column>(create(RDBEntityDescriptorEnum.Column));
	}

	public PrimaryKey createPrimaryKey() {
		return create(RDBEntityDescriptorEnum.PrimaryKey);
	}

	public PrimaryKey createPrimaryKey(StringData name, IdMethod idMethod,
			ColumnNames columnNames) {
		return create(RDBEntityDescriptorEnum.PrimaryKey, name, idMethod,
				columnNames);
	}

	public IEntityBuilder<PrimaryKey> buildPrimaryKey() {
		return new EntityBuilder<PrimaryKey>(
				create(RDBEntityDescriptorEnum.PrimaryKey));
	}

	public ColumnNames createColumnNames() {
		return create(RDBEntityDescriptorEnum.ColumnNames);
	}

	public ColumnNames createColumnNames(StringData... entities) {
		return create(RDBEntityDescriptorEnum.ColumnNames, (IEntity[]) entities);
	}

	public ColumnNames createColumnNames(int initialSize) {
		return clone(RDBEntityDescriptorEnum.ColumnNames, initialSize);
	}

	public ForeignKeys createForeignKeys() {
		return create(RDBEntityDescriptorEnum.ForeignKeys);
	}

	public ForeignKeys createForeignKeys(ForeignKey... entities) {
		return create(RDBEntityDescriptorEnum.ForeignKeys, (IEntity[]) entities);
	}

	public ForeignKeys createForeignKeys(int initialSize) {
		return clone(RDBEntityDescriptorEnum.ForeignKeys, initialSize);
	}

	public ForeignKey createForeignKey() {
		return create(RDBEntityDescriptorEnum.ForeignKey);
	}

	public ForeignKey createForeignKey(StringData name, StringData targetTable,
			Action updateAction, Action deleteAction,
			Deferrability deferrability, ColumnReferences columnReferences) {
		return create(RDBEntityDescriptorEnum.ForeignKey, name, targetTable,
				updateAction, deleteAction, deferrability, columnReferences);
	}

	public IEntityBuilder<ForeignKey> buildForeignKey() {
		return new EntityBuilder<ForeignKey>(
				create(RDBEntityDescriptorEnum.ForeignKey));
	}

	public ColumnReferences createColumnReferences() {
		return create(RDBEntityDescriptorEnum.ColumnReferences);
	}

	public ColumnReferences createColumnReferences(ColumnReference... entities) {
		return create(RDBEntityDescriptorEnum.ColumnReferences,
				(IEntity[]) entities);
	}

	public ColumnReferences createColumnReferences(int initialSize) {
		return clone(RDBEntityDescriptorEnum.ColumnReferences, initialSize);
	}

	public ColumnReference createColumnReference() {
		return create(RDBEntityDescriptorEnum.ColumnReference);
	}

	public ColumnReference createColumnReference(StringData source,
			StringData target) {
		return create(RDBEntityDescriptorEnum.ColumnReference, source, target);
	}

	public IEntityBuilder<ColumnReference> buildColumnReference() {
		return new EntityBuilder<ColumnReference>(
				create(RDBEntityDescriptorEnum.ColumnReference));
	}

	public Indices createIndices() {
		return create(RDBEntityDescriptorEnum.Indices);
	}

	public Indices createIndices(Index... entities) {
		return create(RDBEntityDescriptorEnum.Indices, (IEntity[]) entities);
	}

	public Indices createIndices(int initialSize) {
		return clone(RDBEntityDescriptorEnum.Indices, initialSize);
	}

	public Index createIndex() {
		return create(RDBEntityDescriptorEnum.Index);
	}

	public Index createIndex(StringData name, StringData qualifier,
			BooleanData unique, IndexType type, ColumnIndices columnIndices) {
		return create(RDBEntityDescriptorEnum.Index, name, qualifier, unique,
				type, columnIndices);
	}

	public IEntityBuilder<Index> buildIndex() {
		return new EntityBuilder<Index>(create(RDBEntityDescriptorEnum.Index));
	}

	public ColumnIndices createColumnIndices() {
		return create(RDBEntityDescriptorEnum.ColumnIndices);
	}

	public ColumnIndices createColumnIndices(ColumnIndex... entities) {
		return create(RDBEntityDescriptorEnum.ColumnIndices,
				(IEntity[]) entities);
	}

	public ColumnIndices createColumnIndices(int initialSize) {
		return clone(RDBEntityDescriptorEnum.ColumnIndices, initialSize);
	}

	public ColumnIndex createColumnIndex() {
		return create(RDBEntityDescriptorEnum.ColumnIndex);
	}

	public ColumnIndex createColumnIndex(StringData name, Order order) {
		return create(RDBEntityDescriptorEnum.ColumnIndex, name, order);
	}

	public IEntityBuilder<ColumnIndex> buildColumnIndex() {
		return new EntityBuilder<ColumnIndex>(
				create(RDBEntityDescriptorEnum.ColumnIndex));
	}

	public Type createType() {
		return create(RDBEntityDescriptorEnum.Type);
	}

	public Type createType(TypeEnum.Value value) {
		return create(RDBEntityDescriptorEnum.Type, value);
	}

	public IndexType createIndexType() {
		return create(RDBEntityDescriptorEnum.IndexType);
	}

	public IndexType createIndexType(IndexTypeEnum.Value value) {
		return create(RDBEntityDescriptorEnum.IndexType, value);
	}

	public Order createOrder() {
		return create(RDBEntityDescriptorEnum.Order);
	}

	public Order createOrder(OrderEnum.Value value) {
		return create(RDBEntityDescriptorEnum.Order, value);
	}

	public IdMethod createIdMethod() {
		return create(RDBEntityDescriptorEnum.IdMethod);
	}

	public IdMethod createIdMethod(IdMethodEnum.Value value) {
		return create(RDBEntityDescriptorEnum.IdMethod, value);
	}

	public Action createAction() {
		return create(RDBEntityDescriptorEnum.Action);
	}

	public Action createAction(ActionEnum.Value value) {
		return create(RDBEntityDescriptorEnum.Action, value);
	}

	public Deferrability createDeferrability() {
		return create(RDBEntityDescriptorEnum.Deferrability);
	}

	public Deferrability createDeferrability(DeferrabilityEnum.Value value) {
		return create(RDBEntityDescriptorEnum.Deferrability, value);
	}

	public URI createURI() {
		return create(RDBEntityDescriptorEnum.URI);
	}

	public URI createURI(String value) {
		return create(RDBEntityDescriptorEnum.URI, value);
	}

	public Namespace createNamespace() {
		return create(RDBEntityDescriptorEnum.Namespace);
	}

	public Namespace createNamespace(String value) {
		return create(RDBEntityDescriptorEnum.Namespace, value);
	}

	public Name createName() {
		return create(RDBEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(RDBEntityDescriptorEnum.Name, value);
	}

	public StringData createStringData() {
		return create(RDBEntityDescriptorEnum.StringData);
	}

	public StringData createStringData(String value) {
		return create(RDBEntityDescriptorEnum.StringData, value);
	}

	public IntData createIntData() {
		return create(RDBEntityDescriptorEnum.IntData);
	}

	public IntData createIntData(int value) {
		return create(RDBEntityDescriptorEnum.IntData, value);
	}

	public BooleanData createBooleanData() {
		return create(RDBEntityDescriptorEnum.BooleanData);
	}

	public BooleanData createBooleanData(boolean value) {
		return create(RDBEntityDescriptorEnum.BooleanData, value);
	}
}
