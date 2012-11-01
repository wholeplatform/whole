package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class DeferCheckEnum extends EnumType<DeferCheckEnum.Value> {
	public static final int INITIALLY_IMMEDIATE_ord = 0;
	public static final int INITIALLY_DEFERRED_ord = 1;
	public static final DeferCheckEnum instance = new DeferCheckEnum();
	public static final Value INITIALLY_IMMEDIATE = instance
			.valueOf(INITIALLY_IMMEDIATE_ord);
	public static final Value INITIALLY_DEFERRED = instance
			.valueOf(INITIALLY_DEFERRED_ord);

	private DeferCheckEnum() {
		enumValue(INITIALLY_IMMEDIATE_ord, "INITIALLY_IMMEDIATE");
		enumValue(INITIALLY_DEFERRED_ord, "INITIALLY_DEFERRED");
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
