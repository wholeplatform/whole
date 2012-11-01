package org.whole.lang.java.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class AssignmentOperatorEnum extends
		EnumType<AssignmentOperatorEnum.Value> {
	public static final int assign_ord = 0;
	public static final int plus_assign_ord = 1;
	public static final int minus_assign_ord = 2;
	public static final int times_assign_ord = 3;
	public static final int divide_assign_ord = 4;
	public static final int bit_and_assign_ord = 5;
	public static final int bit_or_assign_ord = 6;
	public static final int bit_xor_assign_ord = 7;
	public static final int remainder_assign_ord = 8;
	public static final int left_shift_assign_ord = 9;
	public static final int right_shift_signed_assign_ord = 10;
	public static final int right_shift_unsigned_assign_ord = 11;
	public static final AssignmentOperatorEnum instance = new AssignmentOperatorEnum();
	public static final Value assign = instance.valueOf(assign_ord);
	public static final Value plus_assign = instance.valueOf(plus_assign_ord);
	public static final Value minus_assign = instance.valueOf(minus_assign_ord);
	public static final Value times_assign = instance.valueOf(times_assign_ord);
	public static final Value divide_assign = instance
			.valueOf(divide_assign_ord);
	public static final Value bit_and_assign = instance
			.valueOf(bit_and_assign_ord);
	public static final Value bit_or_assign = instance
			.valueOf(bit_or_assign_ord);
	public static final Value bit_xor_assign = instance
			.valueOf(bit_xor_assign_ord);
	public static final Value remainder_assign = instance
			.valueOf(remainder_assign_ord);
	public static final Value left_shift_assign = instance
			.valueOf(left_shift_assign_ord);
	public static final Value right_shift_signed_assign = instance
			.valueOf(right_shift_signed_assign_ord);
	public static final Value right_shift_unsigned_assign = instance
			.valueOf(right_shift_unsigned_assign_ord);

	private AssignmentOperatorEnum() {
		enumValue(assign_ord, "assign");
		enumValue(plus_assign_ord, "plus_assign");
		enumValue(minus_assign_ord, "minus_assign");
		enumValue(times_assign_ord, "times_assign");
		enumValue(divide_assign_ord, "divide_assign");
		enumValue(bit_and_assign_ord, "bit_and_assign");
		enumValue(bit_or_assign_ord, "bit_or_assign");
		enumValue(bit_xor_assign_ord, "bit_xor_assign");
		enumValue(remainder_assign_ord, "remainder_assign");
		enumValue(left_shift_assign_ord, "left_shift_assign");
		enumValue(right_shift_signed_assign_ord, "right_shift_signed_assign");
		enumValue(right_shift_unsigned_assign_ord,
				"right_shift_unsigned_assign");
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
