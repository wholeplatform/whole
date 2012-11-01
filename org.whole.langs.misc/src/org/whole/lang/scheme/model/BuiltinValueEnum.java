package org.whole.lang.scheme.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class BuiltinValueEnum extends EnumType<BuiltinValueEnum.Value> {
	public static final int boolp_ord = 0;
	public static final int car_ord = 1;
	public static final int cdr_ord = 2;
	public static final int cons_ord = 3;
	public static final int divide_ord = 4;
	public static final int eqvp_ord = 5;
	public static final int intp_ord = 6;
	public static final int list_ord = 7;
	public static final int minus_ord = 8;
	public static final int nullp_ord = 9;
	public static final int pairp_ord = 10;
	public static final int plus_ord = 11;
	public static final int rel_ord = 12;
	public static final int stringeq_ord = 13;
	public static final int stringp_ord = 14;
	public static final int times_ord = 15;
	public static final BuiltinValueEnum instance = new BuiltinValueEnum();
	public static final Value boolp = instance.valueOf(boolp_ord);
	public static final Value car = instance.valueOf(car_ord);
	public static final Value cdr = instance.valueOf(cdr_ord);
	public static final Value cons = instance.valueOf(cons_ord);
	public static final Value divide = instance.valueOf(divide_ord);
	public static final Value eqvp = instance.valueOf(eqvp_ord);
	public static final Value intp = instance.valueOf(intp_ord);
	public static final Value list = instance.valueOf(list_ord);
	public static final Value minus = instance.valueOf(minus_ord);
	public static final Value nullp = instance.valueOf(nullp_ord);
	public static final Value pairp = instance.valueOf(pairp_ord);
	public static final Value plus = instance.valueOf(plus_ord);
	public static final Value rel = instance.valueOf(rel_ord);
	public static final Value stringeq = instance.valueOf(stringeq_ord);
	public static final Value stringp = instance.valueOf(stringp_ord);
	public static final Value times = instance.valueOf(times_ord);

	private BuiltinValueEnum() {
		enumValue(boolp_ord, "boolp");
		enumValue(car_ord, "car");
		enumValue(cdr_ord, "cdr");
		enumValue(cons_ord, "cons");
		enumValue(divide_ord, "divide");
		enumValue(eqvp_ord, "eqvp");
		enumValue(intp_ord, "intp");
		enumValue(list_ord, "list");
		enumValue(minus_ord, "minus");
		enumValue(nullp_ord, "nullp");
		enumValue(pairp_ord, "pairp");
		enumValue(plus_ord, "plus");
		enumValue(rel_ord, "rel");
		enumValue(stringeq_ord, "stringeq");
		enumValue(stringp_ord, "stringp");
		enumValue(times_ord, "times");
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
