package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ConditionTestEnum extends EnumType<ConditionTestEnum.Value> {
	public static final int TRUE_ord = 0;
	public static final int CHANGES_ord = 1;
	public static final ConditionTestEnum instance = new ConditionTestEnum();
	public static final Value TRUE = instance.valueOf(TRUE_ord);
	public static final Value CHANGES = instance.valueOf(CHANGES_ord);

	private ConditionTestEnum() {
		enumValue(TRUE_ord, "TRUE");
		enumValue(CHANGES_ord, "CHANGES");
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
