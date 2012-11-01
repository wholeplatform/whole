package org.whole.lang.rdb.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class IdMethodEnum extends EnumType<IdMethodEnum.Value> {
	public static final int IDENTITY_ord = 0;
	public static final int GENERATED_ord = 1;
	public static final IdMethodEnum instance = new IdMethodEnum();
	public static final Value IDENTITY = instance.valueOf(IDENTITY_ord);
	public static final Value GENERATED = instance.valueOf(GENERATED_ord);

	private IdMethodEnum() {
		enumValue(IDENTITY_ord, "IDENTITY");
		enumValue(GENERATED_ord, "GENERATED");
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
