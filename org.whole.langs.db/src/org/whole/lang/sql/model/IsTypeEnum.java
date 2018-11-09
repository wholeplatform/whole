package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class IsTypeEnum extends EnumType<IsTypeEnum.Value> {
	public static final int NULL_ord = 0;
	public static final int NOT_NULL_ord = 1;
	public static final int TRUE_ord = 2;
	public static final int NOT_TRUE_ord = 3;
	public static final int FALSE_ord = 4;
	public static final int NOT_FALSE_ord = 5;
	public static final int UNKNOWN_ord = 6;
	public static final int NOT_UNKNOWN_ord = 7;
	public static final IsTypeEnum instance = new IsTypeEnum();
	public static final Value NULL = instance.valueOf(NULL_ord);
	public static final Value NOT_NULL = instance.valueOf(NOT_NULL_ord);
	public static final Value TRUE = instance.valueOf(TRUE_ord);
	public static final Value NOT_TRUE = instance.valueOf(NOT_TRUE_ord);
	public static final Value FALSE = instance.valueOf(FALSE_ord);
	public static final Value NOT_FALSE = instance.valueOf(NOT_FALSE_ord);
	public static final Value UNKNOWN = instance.valueOf(UNKNOWN_ord);
	public static final Value NOT_UNKNOWN = instance.valueOf(NOT_UNKNOWN_ord);

	private IsTypeEnum() {
		enumValue(NULL_ord, "NULL");
		enumValue(NOT_NULL_ord, "NOT_NULL");
		enumValue(TRUE_ord, "TRUE");
		enumValue(NOT_TRUE_ord, "NOT_TRUE");
		enumValue(FALSE_ord, "FALSE");
		enumValue(NOT_FALSE_ord, "NOT_FALSE");
		enumValue(UNKNOWN_ord, "UNKNOWN");
		enumValue(NOT_UNKNOWN_ord, "NOT_UNKNOWN");
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
