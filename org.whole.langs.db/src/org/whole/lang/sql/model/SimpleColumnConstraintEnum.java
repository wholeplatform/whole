package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class SimpleColumnConstraintEnum extends EnumType<SimpleColumnConstraintEnum.Value> {
	public static final int NULL_ord = 0;
	public static final int NOT_NULL_ord = 1;
	public static final int PRIMARY_KEY_ord = 2;
	public static final int UNIQUE_ord = 3;
	public static final int AUTOINCREMENT_ord = 4;
	public static final SimpleColumnConstraintEnum instance = new SimpleColumnConstraintEnum();
	public static final Value NULL = instance.valueOf(NULL_ord);
	public static final Value NOT_NULL = instance.valueOf(NOT_NULL_ord);
	public static final Value PRIMARY_KEY = instance.valueOf(PRIMARY_KEY_ord);
	public static final Value UNIQUE = instance.valueOf(UNIQUE_ord);
	public static final Value AUTOINCREMENT = instance.valueOf(AUTOINCREMENT_ord);

	private SimpleColumnConstraintEnum() {
		enumValue(NULL_ord, "NULL");
		enumValue(NOT_NULL_ord, "NOT_NULL");
		enumValue(PRIMARY_KEY_ord, "PRIMARY_KEY");
		enumValue(UNIQUE_ord, "UNIQUE");
		enumValue(AUTOINCREMENT_ord, "AUTOINCREMENT");
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
