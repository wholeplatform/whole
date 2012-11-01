package org.whole.lang.java.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class PrefixOperatorEnum extends EnumType<PrefixOperatorEnum.Value> {
	public static final int increment_ord = 0;
	public static final int decrement_ord = 1;
	public static final int plus_ord = 2;
	public static final int minus_ord = 3;
	public static final int complement_ord = 4;
	public static final int not_ord = 5;
	public static final PrefixOperatorEnum instance = new PrefixOperatorEnum();
	public static final Value increment = instance.valueOf(increment_ord);
	public static final Value decrement = instance.valueOf(decrement_ord);
	public static final Value plus = instance.valueOf(plus_ord);
	public static final Value minus = instance.valueOf(minus_ord);
	public static final Value complement = instance.valueOf(complement_ord);
	public static final Value not = instance.valueOf(not_ord);

	private PrefixOperatorEnum() {
		enumValue(increment_ord, "increment");
		enumValue(decrement_ord, "decrement");
		enumValue(plus_ord, "plus");
		enumValue(minus_ord, "minus");
		enumValue(complement_ord, "complement");
		enumValue(not_ord, "not");
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
