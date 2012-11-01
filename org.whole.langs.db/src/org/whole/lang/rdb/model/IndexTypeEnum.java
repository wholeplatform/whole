package org.whole.lang.rdb.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class IndexTypeEnum extends EnumType<IndexTypeEnum.Value> {
	public static final int HASHED_ord = 0;
	public static final int CLUSTERED_ord = 1;
	public static final IndexTypeEnum instance = new IndexTypeEnum();
	public static final Value HASHED = instance.valueOf(HASHED_ord);
	public static final Value CLUSTERED = instance.valueOf(CLUSTERED_ord);

	private IndexTypeEnum() {
		enumValue(HASHED_ord, "HASHED");
		enumValue(CLUSTERED_ord, "CLUSTERED");
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
