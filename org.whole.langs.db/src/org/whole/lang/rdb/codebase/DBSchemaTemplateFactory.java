package org.whole.lang.rdb.codebase;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.rdb.builders.IRDBBuilder;
import org.whole.lang.rdb.factories.RDBEntityFactory;
import org.whole.lang.rdb.model.ActionEnum;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.rdb.model.DeferrabilityEnum;
import org.whole.lang.rdb.model.IdMethodEnum;
import org.whole.lang.rdb.model.IndexTypeEnum;
import org.whole.lang.rdb.model.OrderEnum;
import org.whole.lang.rdb.model.TypeEnum;
import org.whole.lang.rdb.model.TypeEnum.Value;
import org.whole.lang.rdb.reflect.RDBLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @author Enrico Persiani
 */
public class DBSchemaTemplateFactory extends AbstractTemplateFactory<Database> {
	protected Connection connection;
	protected String catalog;
	protected String schema;
	protected DatabaseMetaData dmd;
	protected IRDBBuilder rdbb;
	protected ICommonsBuilder cb;

	protected RDBEntityFactory rdbef;

	public DBSchemaTemplateFactory(Connection connection, String catalog, String schema) {
		this.connection = connection;
		this.catalog = catalog;
		this.schema = schema;
		this.rdbef = RDBEntityFactory.instance(RegistryConfigurations.RESOLVER);
	}

	public void apply(IBuilderOperation op) {
		cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		rdbb = (IRDBBuilder) op.wGetBuilder(RDBLanguageKit.URI);
		try {
			dmd = connection.getMetaData();
			buildDatabase();
		} catch (Exception e) {
			throw new IllegalStateException("cannot import database schema", e);
		}
	}

	protected void buildStringData(String name) {
		if (name != null)
			rdbb.StringData(name);
		else
			cb.Resolver();
	}

	protected void buildDatabase() throws SQLException {
		rdbb.Database_();
		rdbb.URI(dmd.getURL() != null ? dmd.getURL() : "urn:lang:rdb:generated");
		rdbb.Namespace("org.whole.lang.rdb.generated");
		buildSchemas();
		rdbb._Database();
	}
	
	protected void buildSchemas() throws SQLException {
		rdbb.Schemas_();
		
		if (schema != null)
			buildSchema(schema);
		else {
			ResultSet rs = dmd.getSchemas();
			while (rs.next())
				buildSchema(rs.getString("TABLE_SCHEM"));
			rs.close();
		}

		rdbb._Schemas();
	}

	protected void buildSchema(String schema) throws SQLException {
		rdbb.Schema_();
		buildStringData(schema.length() == 0 ? null : schema);
		cb.Resolver();// modelName
		rdbb.Tables_();

		ResultSet rs = dmd.getTables(catalog, schema, null, new String[] { "TABLE" });
		while (rs.next())
			buildTable(rs.getString("TABLE_NAME"), rs.getString("REMARKS"));
		rs.close();

		rdbb._Tables();
		rdbb._Schema();
	}

	protected void buildTable(String name, String remarks) throws SQLException {
		rdbb.Table_();
		buildStringData(name);
		cb.Resolver();
		buildColums(name);
		buildPrimaryKey(name);
		buildForeignKeys(name);
		buildIndexes(name);
		if (remarks != null && remarks.length() > 0)
			buildStringData(remarks);
		rdbb._Table();
	}

	protected void buildColums(String name) throws SQLException{
		ResultSet rs = dmd.getColumns(catalog, schema, name, "%");
		if (!rs.next()) {
			cb.Resolver();
			return;
		}

		rdbb.Columns_();
		do {
			rdbb.Column_();
			
			buildStringData(rs.getString("COLUMN_NAME"));
			cb.Resolver(); // featureName
			cb.Resolver(); // entityName

			String sqlType = getSqlTypesMap().get(rs.getInt("DATA_TYPE"));
			Value value = TypeEnum.instance.valueOf(sqlType);
			rdbb.Type(value);

			switch (value.getOrdinal()) {
			// SP
			case TypeEnum.NUMERIC_ord:
			case TypeEnum.DECIMAL_ord:
				rdbb.IntData(rs.getInt("COLUMN_SIZE"));
				rdbb.IntData(rs.getInt("DECIMAL_DIGITS"));
				break;

			// Precision
			case TypeEnum.TIME_ord:
			case TypeEnum.TIMESTAMP_ord:
			case TypeEnum.FLOAT_ord:

			// Length
			case TypeEnum.CHAR_ord:
			case TypeEnum.VARCHAR_ord:
			case TypeEnum.LONGVARCHAR_ord:
			case TypeEnum.BINARY_ord:
			case TypeEnum.VARBINARY_ord:
			case TypeEnum.LONGVARBINARY_ord:
			case TypeEnum.ARRAY_ord:
				rdbb.IntData(rs.getInt("COLUMN_SIZE"));
				cb.Resolver();
				break;

			// NO
			default:
			case TypeEnum.DATE_ord:
			case TypeEnum.BIT_ord:
			case TypeEnum.BOOLEAN_ord:
			case TypeEnum.BIGINT_ord:
			case TypeEnum.INTEGER_ord:
			case TypeEnum.SMALLINT_ord:
			case TypeEnum.TINYINT_ord:
			case TypeEnum.REAL_ord:
			case TypeEnum.DOUBLE_ord:
			case TypeEnum.TEXT_ord:
			case TypeEnum.BLOB_ord:
			case TypeEnum.CLOB_ord:
			case TypeEnum.DATALINK_ord:
			case TypeEnum.REF_ord:
				cb.Resolver();
				cb.Resolver();
				break;
			}

			int nullable = rs.getInt("NULLABLE");
			if (nullable != DatabaseMetaData.columnNullableUnknown) 
				rdbb.BooleanData(nullable == DatabaseMetaData.columnNullable);
			else
				cb.Resolver();

			String defaultValue = rs.getString("COLUMN_DEF");
			if (defaultValue != null)
				rdbb.StringData(defaultValue);
			else
				cb.Resolver();

			String remarks = rs.getString("REMARKS");
			if (remarks != null && remarks.length() > 0)
				buildStringData(remarks);
			rdbb._Columns();
		} while (rs.next());
		rs.close();

		rdbb._Columns();
	}
	
	protected void buildPrimaryKey(String name) throws SQLException {
		ResultSet rs = dmd.getPrimaryKeys(catalog, schema, name);
		if (!rs.next()) {
			cb.Resolver();
			return;
		}

		rdbb.PrimaryKey_();
		buildStringData(rs.getString("PK_NAME"));
		rdbb.IdMethod(IdMethodEnum.IDENTITY);
		rdbb.ColumnNames_();

		Map<Integer, String> namesMap = new HashMap<Integer, String>();
		do {
			namesMap.put(rs.getShort("KEY_SEQ")-1, rs.getString("COLUMN_NAME"));
		} while (rs.next());
		rs.close();
		
		for (int i=0, size=namesMap.size(); i<size; i++)
			buildStringData(namesMap.get(i));

		rdbb._ColumnNames();
		rdbb._PrimaryKey();
	}

	protected void buildAction(short actionRule) {
		switch (actionRule) {
		case DatabaseMetaData.importedKeyRestrict:
			rdbb.Action(ActionEnum.RESTRICT);
			break;

		case DatabaseMetaData.importedKeyCascade:
			rdbb.Action(ActionEnum.CASCADE);
			break;

		case DatabaseMetaData.importedKeySetNull:
			rdbb.Action(ActionEnum.SET_NULL);
			break;
			
		case DatabaseMetaData.importedKeySetDefault:
			rdbb.Action(ActionEnum.SET_DEFAULT);
			break;

		case DatabaseMetaData.importedKeyNoAction:
		default:
			cb.Resolver();
			break;
		}
	}

	protected void buildForeignKeys(String name) throws SQLException {
		ResultSet rs = dmd.getImportedKeys(catalog, schema, name);
		if (!rs.next()) {
			cb.Resolver();
			return;
		}

		String lastPkTableName = null;
		rdbb.ForeignKeys_();

		do {
			String pkTableName = rs.getString("PKTABLE_NAME");
			if (!pkTableName.equals(lastPkTableName)) {
				if (lastPkTableName != null) {
					// terminate previous foreign key if any
					rdbb._ColumnReferences();
					rdbb._ForeignKey();
				}
				lastPkTableName = pkTableName;

				rdbb.ForeignKey_();
				buildStringData(rs.getString("FK_NAME"));
				buildStringData(pkTableName);

				buildAction(rs.getShort("UPDATE_RULE"));
				buildAction(rs.getShort("DELETE_RULE"));
		
				switch (rs.getShort("DEFERRABILITY")) {
				case DatabaseMetaData.importedKeyInitiallyDeferred:
					rdbb.Deferrability(DeferrabilityEnum.INITIALLY_DEFERRED);
					break;
		
				case DatabaseMetaData.importedKeyInitiallyImmediate:
					rdbb.Deferrability(DeferrabilityEnum.INITIALLY_IMMEDIATE);
					break;

				case DatabaseMetaData.importedKeyNotDeferrable:
				default:
					cb.Resolver();
				}

				rdbb.ColumnReferences_();
			}

			rdbb.ColumnReference_();
			rdbb.StringData(rs.getString("FKCOLUMN_NAME"));
			rdbb.StringData(rs.getString("PKCOLUMN_NAME"));
			rdbb._ColumnReference();

		} while (rs.next());
		rs.close();

		// terminate last foreign key
		rdbb._ColumnReferences();
		rdbb._ForeignKey();

		rdbb._ForeignKeys();
	}

	protected void buildIndexes(String name) throws SQLException {
		ResultSet rs = dmd.getIndexInfo(catalog, schema, name, false, true);
		if (!rs.next()) {
			cb.Resolver();
			return;
		}

		String lastIndexName = null;
		do {
			short type = rs.getShort("TYPE");
			if (type == DatabaseMetaData.tableIndexStatistic)
				continue;

			if (lastIndexName == null)
				rdbb.Indices_();

			String indexName = rs.getString("INDEX_NAME");
			if (!indexName.equals(lastIndexName)) {
				if (lastIndexName != null) {
					// terminate previous index if any
					rdbb._ColumnIndices();
					rdbb._Index();
				}
				lastIndexName = indexName;

				rdbb.Index_();
				buildStringData(indexName);
				buildStringData(rs.getString("INDEX_QUALIFIER"));

				rdbb.BooleanData(!rs.getBoolean("NON_UNIQUE"));

				switch (type) {
				case DatabaseMetaData.tableIndexHashed:
					rdbb.IndexType(IndexTypeEnum.HASHED);
					break;

				case DatabaseMetaData.tableIndexClustered:
					rdbb.IndexType(IndexTypeEnum.HASHED);
					break;

				case DatabaseMetaData.tableIndexOther:
					cb.Resolver();
					break;
				}

				rdbb.ColumnIndices_();
			}

			rdbb.ColumnIndex_();
			rdbb.StringData(rs.getString("COLUMN_NAME"));
			String order = rs.getString("ASC_OR_DESC");
			if (order != null)
				rdbb.Order(order.charAt(0) == 'A' ?
						OrderEnum.ASCENDING : OrderEnum.DESCENDING);
			rdbb._ColumnIndex();

		} while (rs.next());
		rs.close();

		// terminate last index if any
		if (lastIndexName != null) {
			rdbb._ColumnIndices();
			rdbb._Index();
			rdbb._Indices();
		} else
			cb.Resolver();
	}

	private Map<Integer, String> typesMap;
	public void setSqlTypesMap(Map<Integer, String> typesMap) {
		this.typesMap = typesMap;
	}
	public Map<Integer, String> getSqlTypesMap() {
		if (typesMap == null) {
			typesMap = new HashMap<Integer, String>();
			for (Field field : Types.class.getFields())
				try {
					typesMap.put((Integer) field.get(null), field.getName());
				} catch (Exception e) {
					throw new IllegalStateException("cannot calculate sql type mapping", e);
				}
		}
		return typesMap;
	}
}
