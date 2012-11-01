package org.whole.lang.semantics.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class BindingOpEnum extends EnumType<BindingOpEnum.Value> {
	public static final int BIND_ord = 0;
	public static final int UNBIND_ord = 1;
	public static final int FRESH_BIND_ord = 2;
	public static final int MATCH_BIND_ord = 3;
	public static final BindingOpEnum instance = new BindingOpEnum();
	public static final Value BIND = instance.valueOf(BIND_ord);
	public static final Value UNBIND = instance.valueOf(UNBIND_ord);
	public static final Value FRESH_BIND = instance.valueOf(FRESH_BIND_ord);
	public static final Value MATCH_BIND = instance.valueOf(MATCH_BIND_ord);

	private BindingOpEnum() {
		enumValue(BIND_ord, "BIND");
		enumValue(UNBIND_ord, "UNBIND");
		enumValue(FRESH_BIND_ord, "FRESH_BIND");
		enumValue(MATCH_BIND_ord, "MATCH_BIND");
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
