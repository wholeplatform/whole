package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class SelectTypeEnum extends EnumType<SelectTypeEnum.Value> {
	public static final int DISTINCT_ord = 0;
	public static final int ALL_ord = 1;
	public static final SelectTypeEnum instance = new SelectTypeEnum();
	public static final Value DISTINCT = instance.valueOf(DISTINCT_ord);
	public static final Value ALL = instance.valueOf(ALL_ord);

	private SelectTypeEnum() {
		enumValue(DISTINCT_ord, "DISTINCT");
		enumValue(ALL_ord, "ALL");
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
