package org.whole.lang.rdb.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class TypeEnum extends EnumType<TypeEnum.Value> {
	public static final int BOOLEAN_ord = 0;
	public static final int TINYINT_ord = 1;
	public static final int SMALLINT_ord = 2;
	public static final int INTEGER_ord = 3;
	public static final int BIGINT_ord = 4;
	public static final int FLOAT_ord = 5;
	public static final int REAL_ord = 6;
	public static final int DOUBLE_ord = 7;
	public static final int NUMERIC_ord = 8;
	public static final int DECIMAL_ord = 9;
	public static final int CHAR_ord = 10;
	public static final int VARCHAR_ord = 11;
	public static final int TEXT_ord = 12;
	public static final int DATE_ord = 13;
	public static final int TIME_ord = 14;
	public static final int TIMESTAMP_ord = 15;
	public static final int LONGVARBINARY_ord = 16;
	public static final int LONGVARCHAR_ord = 17;
	public static final int BINARY_ord = 18;
	public static final int ARRAY_ord = 19;
	public static final int BIT_ord = 20;
	public static final int BLOB_ord = 21;
	public static final int CLOB_ord = 22;
	public static final int DATALINK_ord = 23;
	public static final int REF_ord = 24;
	public static final int VARBINARY_ord = 25;
	public static final TypeEnum instance = new TypeEnum();
	public static final Value BOOLEAN = instance.valueOf(BOOLEAN_ord);
	public static final Value TINYINT = instance.valueOf(TINYINT_ord);
	public static final Value SMALLINT = instance.valueOf(SMALLINT_ord);
	public static final Value INTEGER = instance.valueOf(INTEGER_ord);
	public static final Value BIGINT = instance.valueOf(BIGINT_ord);
	public static final Value FLOAT = instance.valueOf(FLOAT_ord);
	public static final Value REAL = instance.valueOf(REAL_ord);
	public static final Value DOUBLE = instance.valueOf(DOUBLE_ord);
	public static final Value NUMERIC = instance.valueOf(NUMERIC_ord);
	public static final Value DECIMAL = instance.valueOf(DECIMAL_ord);
	public static final Value CHAR = instance.valueOf(CHAR_ord);
	public static final Value VARCHAR = instance.valueOf(VARCHAR_ord);
	public static final Value TEXT = instance.valueOf(TEXT_ord);
	public static final Value DATE = instance.valueOf(DATE_ord);
	public static final Value TIME = instance.valueOf(TIME_ord);
	public static final Value TIMESTAMP = instance.valueOf(TIMESTAMP_ord);
	public static final Value LONGVARBINARY = instance
			.valueOf(LONGVARBINARY_ord);
	public static final Value LONGVARCHAR = instance.valueOf(LONGVARCHAR_ord);
	public static final Value BINARY = instance.valueOf(BINARY_ord);
	public static final Value ARRAY = instance.valueOf(ARRAY_ord);
	public static final Value BIT = instance.valueOf(BIT_ord);
	public static final Value BLOB = instance.valueOf(BLOB_ord);
	public static final Value CLOB = instance.valueOf(CLOB_ord);
	public static final Value DATALINK = instance.valueOf(DATALINK_ord);
	public static final Value REF = instance.valueOf(REF_ord);
	public static final Value VARBINARY = instance.valueOf(VARBINARY_ord);

	private TypeEnum() {
		enumValue(BOOLEAN_ord, "BOOLEAN");
		enumValue(TINYINT_ord, "TINYINT");
		enumValue(SMALLINT_ord, "SMALLINT");
		enumValue(INTEGER_ord, "INTEGER");
		enumValue(BIGINT_ord, "BIGINT");
		enumValue(FLOAT_ord, "FLOAT");
		enumValue(REAL_ord, "REAL");
		enumValue(DOUBLE_ord, "DOUBLE");
		enumValue(NUMERIC_ord, "NUMERIC");
		enumValue(DECIMAL_ord, "DECIMAL");
		enumValue(CHAR_ord, "CHAR");
		enumValue(VARCHAR_ord, "VARCHAR");
		enumValue(TEXT_ord, "TEXT");
		enumValue(DATE_ord, "DATE");
		enumValue(TIME_ord, "TIME");
		enumValue(TIMESTAMP_ord, "TIMESTAMP");
		enumValue(LONGVARBINARY_ord, "LONGVARBINARY");
		enumValue(LONGVARCHAR_ord, "LONGVARCHAR");
		enumValue(BINARY_ord, "BINARY");
		enumValue(ARRAY_ord, "ARRAY");
		enumValue(BIT_ord, "BIT");
		enumValue(BLOB_ord, "BLOB");
		enumValue(CLOB_ord, "CLOB");
		enumValue(DATALINK_ord, "DATALINK");
		enumValue(REF_ord, "REF");
		enumValue(VARBINARY_ord, "VARBINARY");
	}

	private static final long serialVersionUID = 1;

	protected void enumValue(int ordinal, String name) {
		if (valueOf(name) == null)
			putEnumValue(new Value(ordinal, name));
	}

	protected void enumValue(int ordinal, String name, String implName) {
		if (valueOf(name) == null)
			putEnumValue(new Value(ordinal, name, implName));
	}

	public static class Value extends EnumValueImpl {
		private static final long serialVersionUID = 1;

		public Value() {
			super();
		}

		public Value(int ordinal, String name) {
			super(ordinal, name);
		}

		public Value(int ordinal, String name, String implName) {
			super(ordinal, name, implName);
		}
	}
}
