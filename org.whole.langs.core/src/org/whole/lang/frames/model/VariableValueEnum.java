package org.whole.lang.frames.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class VariableValueEnum extends EnumType<VariableValueEnum.Value> {
	public static final int NOT_SELECTED_ord = 0;
	public static final int SELECTED_ord = 1;
	public static final int EXCLUDED_ord = 2;
	public static final int REQUIRED_ord = 3;
	public static final VariableValueEnum instance = new VariableValueEnum();
	public static final Value NOT_SELECTED = instance.valueOf(NOT_SELECTED_ord);
	public static final Value SELECTED = instance.valueOf(SELECTED_ord);
	public static final Value EXCLUDED = instance.valueOf(EXCLUDED_ord);
	public static final Value REQUIRED = instance.valueOf(REQUIRED_ord);

	private VariableValueEnum() {
		enumValue(NOT_SELECTED_ord, "NOT_SELECTED");
		enumValue(SELECTED_ord, "SELECTED");
		enumValue(EXCLUDED_ord, "EXCLUDED");
		enumValue(REQUIRED_ord, "REQUIRED");
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
