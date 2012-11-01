package org.whole.lang.rdb.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class DeferrabilityEnum extends EnumType<DeferrabilityEnum.Value> {
	public static final int INITIALLY_DEFERRED_ord = 0;
	public static final int INITIALLY_IMMEDIATE_ord = 1;
	public static final DeferrabilityEnum instance = new DeferrabilityEnum();
	public static final Value INITIALLY_DEFERRED = instance
			.valueOf(INITIALLY_DEFERRED_ord);
	public static final Value INITIALLY_IMMEDIATE = instance
			.valueOf(INITIALLY_IMMEDIATE_ord);

	private DeferrabilityEnum() {
		enumValue(INITIALLY_DEFERRED_ord, "INITIALLY_DEFERRED");
		enumValue(INITIALLY_IMMEDIATE_ord, "INITIALLY_IMMEDIATE");
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
