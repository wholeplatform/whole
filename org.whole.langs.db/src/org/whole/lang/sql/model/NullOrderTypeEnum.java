package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class NullOrderTypeEnum extends EnumType<NullOrderTypeEnum.Value> {
	public static final int NULLS_LAST_ord = 0;
	public static final int NULLS_FIRST_ord = 1;
	public static final NullOrderTypeEnum instance = new NullOrderTypeEnum();
	public static final Value NULLS_LAST = instance.valueOf(NULLS_LAST_ord);
	public static final Value NULLS_FIRST = instance.valueOf(NULLS_FIRST_ord);

	private NullOrderTypeEnum() {
		enumValue(NULLS_LAST_ord, "NULLS_LAST");
		enumValue(NULLS_FIRST_ord, "NULLS_FIRST");
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
