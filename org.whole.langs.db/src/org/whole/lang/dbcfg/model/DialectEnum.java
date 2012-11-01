package org.whole.lang.dbcfg.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class DialectEnum extends EnumType<DialectEnum.Value> {
	public static final int ORACLE_ord = 0;
	public static final int DB2_ord = 1;
	public static final int DB2_UDB_ord = 2;
	public static final int MSSQL_ord = 3;
	public static final int PGSQL_ord = 4;
	public static final int MYSQL_ord = 5;
	public static final DialectEnum instance = new DialectEnum();
	public static final Value ORACLE = instance.valueOf(ORACLE_ord);
	public static final Value DB2 = instance.valueOf(DB2_ord);
	public static final Value DB2_UDB = instance.valueOf(DB2_UDB_ord);
	public static final Value MSSQL = instance.valueOf(MSSQL_ord);
	public static final Value PGSQL = instance.valueOf(PGSQL_ord);
	public static final Value MYSQL = instance.valueOf(MYSQL_ord);

	private DialectEnum() {
		enumValue(ORACLE_ord, "ORACLE");
		enumValue(DB2_ord, "DB2");
		enumValue(DB2_UDB_ord, "DB2_UDB");
		enumValue(MSSQL_ord, "MSSQL");
		enumValue(PGSQL_ord, "PGSQL");
		enumValue(MYSQL_ord, "MYSQL");
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
