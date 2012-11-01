package org.whole.lang.testentities.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class EnumTestEntityEnum extends EnumType<EnumTestEntityEnum.Value> {
	public static final int zero_ord = 0;
	public static final int one_ord = 1;
	public static final int two_ord = 2;
	public static final int three_ord = 3;
	public static final int four_ord = 4;
	public static final int five_ord = 5;
	public static final EnumTestEntityEnum instance = new EnumTestEntityEnum();
	public static final Value zero = instance.valueOf(zero_ord);
	public static final Value one = instance.valueOf(one_ord);
	public static final Value two = instance.valueOf(two_ord);
	public static final Value three = instance.valueOf(three_ord);
	public static final Value four = instance.valueOf(four_ord);
	public static final Value five = instance.valueOf(five_ord);

	private EnumTestEntityEnum() {
		enumValue(zero_ord, "zero");
		enumValue(one_ord, "one");
		enumValue(two_ord, "two");
		enumValue(three_ord, "three");
		enumValue(four_ord, "four");
		enumValue(five_ord, "five");
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
