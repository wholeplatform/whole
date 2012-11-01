package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class BinaryOperatorEnum extends EnumType<BinaryOperatorEnum.Value> {
	public static final int sum_ord = 0;
	public static final int sub_ord = 1;
	public static final int mul_ord = 2;
	public static final int div_ord = 3;
	public static final int concat_ord = 4;
	public static final BinaryOperatorEnum instance = new BinaryOperatorEnum();
	public static final Value sum = instance.valueOf(sum_ord);
	public static final Value sub = instance.valueOf(sub_ord);
	public static final Value mul = instance.valueOf(mul_ord);
	public static final Value div = instance.valueOf(div_ord);
	public static final Value concat = instance.valueOf(concat_ord);

	private BinaryOperatorEnum() {
		enumValue(sum_ord, "sum");
		enumValue(sub_ord, "sub");
		enumValue(mul_ord, "mul");
		enumValue(div_ord, "div");
		enumValue(concat_ord, "concat");
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
