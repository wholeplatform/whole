package org.whole.lang.frames.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class DomainEnum extends EnumType<DomainEnum.Value> {
	public static final int BOOLEAN_ord = 0;
	public static final int BYTE_ord = 1;
	public static final int SHORT_ord = 2;
	public static final int INT_ord = 3;
	public static final int LONG_ord = 4;
	public static final int FLOAT_ord = 5;
	public static final int DOUBLE_ord = 6;
	public static final int CHAR_ord = 7;
	public static final int STRING_ord = 8;
	public static final DomainEnum instance = new DomainEnum();
	public static final Value BOOLEAN = instance.valueOf(BOOLEAN_ord);
	public static final Value BYTE = instance.valueOf(BYTE_ord);
	public static final Value SHORT = instance.valueOf(SHORT_ord);
	public static final Value INT = instance.valueOf(INT_ord);
	public static final Value LONG = instance.valueOf(LONG_ord);
	public static final Value FLOAT = instance.valueOf(FLOAT_ord);
	public static final Value DOUBLE = instance.valueOf(DOUBLE_ord);
	public static final Value CHAR = instance.valueOf(CHAR_ord);
	public static final Value STRING = instance.valueOf(STRING_ord);

	private DomainEnum() {
		enumValue(BOOLEAN_ord, "BOOLEAN");
		enumValue(BYTE_ord, "BYTE");
		enumValue(SHORT_ord, "SHORT");
		enumValue(INT_ord, "INT");
		enumValue(LONG_ord, "LONG");
		enumValue(FLOAT_ord, "FLOAT");
		enumValue(DOUBLE_ord, "DOUBLE");
		enumValue(CHAR_ord, "CHAR");
		enumValue(STRING_ord, "STRING");
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
