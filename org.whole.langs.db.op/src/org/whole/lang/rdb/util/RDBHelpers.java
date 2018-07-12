package org.whole.lang.rdb.util;

import static org.whole.lang.sql.reflect.SQLEntityDescriptorEnum.*;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.rdb.model.Type;
import org.whole.lang.rdb.model.TypeEnum;
import org.whole.lang.rdb.model.TypeEnum.Value;
import org.whole.lang.reflect.EntityDescriptor;

public class RDBHelpers {
	private static Map<Value, String> dataTypeMap;
	private static Map<Value, EntityDescriptor<?>> sqlValueMap;

	static {
		dataTypeMap = new HashMap<Value, String>();
		dataTypeMap.put(TypeEnum.BIT, "boolean");
		dataTypeMap.put(TypeEnum.BOOLEAN, "boolean");

		dataTypeMap.put(TypeEnum.TINYINT, "int");
		dataTypeMap.put(TypeEnum.SMALLINT, "int");
		dataTypeMap.put(TypeEnum.INTEGER, "int");
		dataTypeMap.put(TypeEnum.BIGINT, "int");

		dataTypeMap.put(TypeEnum.REAL, "float");
		dataTypeMap.put(TypeEnum.FLOAT, "double");
		dataTypeMap.put(TypeEnum.DOUBLE, "double");

		dataTypeMap.put(TypeEnum.NUMERIC, "java.math.BigDecimal");
		dataTypeMap.put(TypeEnum.DECIMAL, "java.math.BigDecimal");

		dataTypeMap.put(TypeEnum.TEXT, "String");
		dataTypeMap.put(TypeEnum.DATALINK, "String");
		dataTypeMap.put(TypeEnum.REF, "String");

		dataTypeMap.put(TypeEnum.DATE, "java.sql.Date");
		dataTypeMap.put(TypeEnum.TIME, "java.sql.Time");
		dataTypeMap.put(TypeEnum.TIMESTAMP, "java.sql.Timestamp");

		dataTypeMap.put(TypeEnum.ARRAY, "java.sql.Array");

		dataTypeMap.put(TypeEnum.CHAR, "String");
		dataTypeMap.put(TypeEnum.VARCHAR, "String");
		dataTypeMap.put(TypeEnum.LONGVARCHAR, "String");

		dataTypeMap.put(TypeEnum.LONGVARBINARY, "Object");
		dataTypeMap.put(TypeEnum.BINARY, "Object");
		dataTypeMap.put(TypeEnum.VARBINARY, "Object");

		dataTypeMap.put(TypeEnum.BLOB, "java.sql.Blob");
		dataTypeMap.put(TypeEnum.CLOB, "java.sql.Clob");

		sqlValueMap = new HashMap<Value, EntityDescriptor<?>>();
		sqlValueMap.put(TypeEnum.BOOLEAN, BooleanExpression);
		sqlValueMap.put(TypeEnum.BOOLEAN, BooleanExpression);

		sqlValueMap.put(TypeEnum.TINYINT, IntValue);
		sqlValueMap.put(TypeEnum.SMALLINT, IntValue);
		sqlValueMap.put(TypeEnum.INTEGER, IntValue);
		sqlValueMap.put(TypeEnum.BIGINT, IntValue);

		sqlValueMap.put(TypeEnum.REAL, DoubleValue);
		sqlValueMap.put(TypeEnum.FLOAT, DoubleValue);
		sqlValueMap.put(TypeEnum.DOUBLE, DoubleValue);

//		sqlValueMap.put(TypeEnum.NUMERIC, "java.math.BigDecimal");
//		sqlValueMap.put(TypeEnum.DECIMAL, "java.math.BigDecimal");

		sqlValueMap.put(TypeEnum.TEXT, StringValue);
		sqlValueMap.put(TypeEnum.DATALINK, StringValue);
		sqlValueMap.put(TypeEnum.REF, StringValue);

		sqlValueMap.put(TypeEnum.DATE, DateValue);
		sqlValueMap.put(TypeEnum.TIME, TimeValue);
		sqlValueMap.put(TypeEnum.TIMESTAMP, TimestampValue);

//		sqlValueMap.put(TypeEnum.ARRAY, "java.sql.Array");

		sqlValueMap.put(TypeEnum.CHAR, StringValue);
		sqlValueMap.put(TypeEnum.VARCHAR, StringValue);
		sqlValueMap.put(TypeEnum.LONGVARCHAR, StringValue);

//		sqlValueMap.put(TypeEnum.LONGVARBINARY, "Object");
//		sqlValueMap.put(TypeEnum.BINARY, "Object");
//		sqlValueMap.put(TypeEnum.VARBINARY, "Object");

//		sqlValueMap.put(TypeEnum.BLOB, "java.sql.Blob");
//		sqlValueMap.put(TypeEnum.CLOB, "java.sql.Clob");
	}

//	//TODO complete
//	public static SQLExpression toSQLValue(Type type, IEntity entity) {
//		EntityDescriptor<?> ed = sqlValueMap.get(type);
//		return (SQLExpression) DataTypeUtils.createFromPersistenceString(ed, DataTypeUtils.getAsPersistenceString(entity));
//	}

//	public static IEntity getFeatureByColumn(ColumnDeclaration column, IEntity entity) {
//		FeatureDescriptorEnum fdEnum = entity.wGetLanguageKit().getFeatureDescriptorEnum();
//		return entity.wGet(fdEnum.valueOf(column.getFeatureName().getValue()));
//	}
//
//	public static SQLExpression getFeatureSQLValue(ColumnDeclaration column, IEntity entity) {
//		return toSQLValue(column.getType(), getFeatureByColumn(column, entity));
//	}

	public static SimpleName toDataType(Type type) {
		return ModelsEntityFactory.instance.createSimpleName(dataTypeMap.get(type.getValue()));
	}

//	private static SQLExpression toSQLExpression(List<SQLExpression> list) {
//		SQLEntityFactory sef = SQLEntityFactory.instance;
//		if (list.size() > 1)
//			return sef.createBooleanBinaryExpression(
//					list.get(0),
//					sef.createBooleanOperator(BooleanOperatorEnum.and),
//					toSQLExpression(list.subList(1, list.size()))
//			);
//		else
//			return list.get(0);
//	}

//	public static SQLExpression createKeyExpression(Table table, IEntity entity) {
//		SQLEntityFactory sef = SQLEntityFactory.instance;
//
//		IEntityIterator<KeyColumn> iterator = IteratorFactory.instance.<KeyColumn>childMatcherIterator(table.getColumns()).usePattern(RDBEntityDescriptorEnum.KeyColumn);
//		List<SQLExpression> equalsList = new ArrayList<SQLExpression>();
//		
//		while (iterator.hasNext()) {
//			KeyColumn keyColumn = iterator.next();
//			IEntity child = getFeatureByColumn(keyColumn, entity);
//			equalsList.add(sef.createBooleanBinaryExpression(
//					sef.createColumnName(keyColumn.getName().getValue()),
//					sef.createBooleanOperator(BooleanOperatorEnum.eq),
//					toSQLValue(keyColumn.getType(), child)
//			));
//		}
//		if (equalsList.size() == 0)
//			throw new IllegalArgumentException("missing primary key");
//		else
//			return toSQLExpression(equalsList);
//	}
}
