package org.whole.lang.frames.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class BindingTimeEnum extends EnumType<BindingTimeEnum.Value> {
	public static final int USE_TIME_ord = 0;
	public static final int REUSE_TIME_ord = 1;
	public static final BindingTimeEnum instance = new BindingTimeEnum();
	public static final Value USE_TIME = instance.valueOf(USE_TIME_ord);
	public static final Value REUSE_TIME = instance.valueOf(REUSE_TIME_ord);

	private BindingTimeEnum() {
		enumValue(USE_TIME_ord, "USE_TIME");
		enumValue(REUSE_TIME_ord, "REUSE_TIME");
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
