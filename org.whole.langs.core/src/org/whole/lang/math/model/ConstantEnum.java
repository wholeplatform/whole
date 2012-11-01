package org.whole.lang.math.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ConstantEnum extends EnumType<ConstantEnum.Value> {
	public static final int pi_ord = 0;
	public static final int e_ord = 1;
	public static final int i_ord = 2;
	public static final int gamma_ord = 3;
	public static final int infinity_ord = 4;
	public static final ConstantEnum instance = new ConstantEnum();
	public static final Value pi = instance.valueOf(pi_ord);
	public static final Value e = instance.valueOf(e_ord);
	public static final Value i = instance.valueOf(i_ord);
	public static final Value gamma = instance.valueOf(gamma_ord);
	public static final Value infinity = instance.valueOf(infinity_ord);

	private ConstantEnum() {
		enumValue(pi_ord, "pi");
		enumValue(e_ord, "e");
		enumValue(i_ord, "i");
		enumValue(gamma_ord, "gamma");
		enumValue(infinity_ord, "infinity");
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
