package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class SwitchTypeEnum extends EnumType<SwitchTypeEnum.Value> {
	public static final int exclusive_ord = 0;
	public static final int inclusive_ord = 1;
	public static final SwitchTypeEnum instance = new SwitchTypeEnum();
	public static final Value exclusive = instance.valueOf(exclusive_ord);
	public static final Value inclusive = instance.valueOf(inclusive_ord);

	private SwitchTypeEnum() {
		enumValue(exclusive_ord, "exclusive");
		enumValue(inclusive_ord, "inclusive");
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
