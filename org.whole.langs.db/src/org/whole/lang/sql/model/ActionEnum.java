package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ActionEnum extends EnumType<ActionEnum.Value> {
	public static final int NO_ACTION_ord = 0;
	public static final int RESTRICT_ord = 1;
	public static final int CASCADE_ord = 2;
	public static final int SET_NULL_ord = 3;
	public static final int SET_DEFAULT_ord = 4;
	public static final ActionEnum instance = new ActionEnum();
	public static final Value NO_ACTION = instance.valueOf(NO_ACTION_ord);
	public static final Value RESTRICT = instance.valueOf(RESTRICT_ord);
	public static final Value CASCADE = instance.valueOf(CASCADE_ord);
	public static final Value SET_NULL = instance.valueOf(SET_NULL_ord);
	public static final Value SET_DEFAULT = instance.valueOf(SET_DEFAULT_ord);

	private ActionEnum() {
		enumValue(NO_ACTION_ord, "NO_ACTION");
		enumValue(RESTRICT_ord, "RESTRICT");
		enumValue(CASCADE_ord, "CASCADE");
		enumValue(SET_NULL_ord, "SET_NULL");
		enumValue(SET_DEFAULT_ord, "SET_DEFAULT");
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
