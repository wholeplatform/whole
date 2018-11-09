package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class MatchEnum extends EnumType<MatchEnum.Value> {
	public static final int FULL_ord = 0;
	public static final int PARTIAL_ord = 1;
	public static final MatchEnum instance = new MatchEnum();
	public static final Value FULL = instance.valueOf(FULL_ord);
	public static final Value PARTIAL = instance.valueOf(PARTIAL_ord);

	private MatchEnum() {
		enumValue(FULL_ord, "FULL");
		enumValue(PARTIAL_ord, "PARTIAL");
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
