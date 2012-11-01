package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class DeferrableEnum extends EnumType<DeferrableEnum.Value> {
	public static final int NOT_DEFERRABLE_ord = 0;
	public static final int DEFERRABLE_ord = 1;
	public static final DeferrableEnum instance = new DeferrableEnum();
	public static final Value NOT_DEFERRABLE = instance
			.valueOf(NOT_DEFERRABLE_ord);
	public static final Value DEFERRABLE = instance.valueOf(DEFERRABLE_ord);

	private DeferrableEnum() {
		enumValue(NOT_DEFERRABLE_ord, "NOT_DEFERRABLE");
		enumValue(DEFERRABLE_ord, "DEFERRABLE");
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
