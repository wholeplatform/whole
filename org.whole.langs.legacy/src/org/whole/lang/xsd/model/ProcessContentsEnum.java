package org.whole.lang.xsd.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ProcessContentsEnum extends EnumType<ProcessContentsEnum.Value> {
	public static final int strict_ord = 0;
	public static final int lax_ord = 1;
	public static final int skip_ord = 2;
	public static final ProcessContentsEnum instance = new ProcessContentsEnum();
	public static final Value strict = instance.valueOf(strict_ord);
	public static final Value lax = instance.valueOf(lax_ord);
	public static final Value skip = instance.valueOf(skip_ord);

	private ProcessContentsEnum() {
		enumValue(strict_ord, "strict");
		enumValue(lax_ord, "lax");
		enumValue(skip_ord, "skip");
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
