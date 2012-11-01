package org.whole.lang.actions.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ActionKindEnum extends EnumType<ActionKindEnum.Value> {
	public static final int INSERT_ord = 0;
	public static final int REPLACE_ord = 1;
	public static final int WRAP_ord = 2;
	public static final int PERFORM_ord = 3;
	public static final ActionKindEnum instance = new ActionKindEnum();
	public static final Value INSERT = instance.valueOf(INSERT_ord);
	public static final Value REPLACE = instance.valueOf(REPLACE_ord);
	public static final Value WRAP = instance.valueOf(WRAP_ord);
	public static final Value PERFORM = instance.valueOf(PERFORM_ord);

	private ActionKindEnum() {
		enumValue(INSERT_ord, "INSERT");
		enumValue(REPLACE_ord, "REPLACE");
		enumValue(WRAP_ord, "WRAP");
		enumValue(PERFORM_ord, "PERFORM");
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
