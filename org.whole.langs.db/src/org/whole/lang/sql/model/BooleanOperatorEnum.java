package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class BooleanOperatorEnum extends EnumType<BooleanOperatorEnum.Value> {
	public static final int and_ord = 0;
	public static final int or_ord = 1;
	public static final int lt_ord = 2;
	public static final int gt_ord = 3;
	public static final int le_ord = 4;
	public static final int ge_ord = 5;
	public static final int eq_ord = 6;
	public static final int ne_ord = 7;
	public static final int like_ord = 8;
	public static final BooleanOperatorEnum instance = new BooleanOperatorEnum();
	public static final Value and = instance.valueOf(and_ord);
	public static final Value or = instance.valueOf(or_ord);
	public static final Value lt = instance.valueOf(lt_ord);
	public static final Value gt = instance.valueOf(gt_ord);
	public static final Value le = instance.valueOf(le_ord);
	public static final Value ge = instance.valueOf(ge_ord);
	public static final Value eq = instance.valueOf(eq_ord);
	public static final Value ne = instance.valueOf(ne_ord);
	public static final Value like = instance.valueOf(like_ord);

	private BooleanOperatorEnum() {
		enumValue(and_ord, "and");
		enumValue(or_ord, "or");
		enumValue(lt_ord, "lt");
		enumValue(gt_ord, "gt");
		enumValue(le_ord, "le");
		enumValue(ge_ord, "ge");
		enumValue(eq_ord, "eq");
		enumValue(ne_ord, "ne");
		enumValue(like_ord, "like");
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
