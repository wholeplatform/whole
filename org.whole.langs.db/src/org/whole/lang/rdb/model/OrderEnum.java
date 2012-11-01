package org.whole.lang.rdb.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class OrderEnum extends EnumType<OrderEnum.Value> {
	public static final int ASCENDING_ord = 0;
	public static final int DESCENDING_ord = 1;
	public static final OrderEnum instance = new OrderEnum();
	public static final Value ASCENDING = instance.valueOf(ASCENDING_ord);
	public static final Value DESCENDING = instance.valueOf(DESCENDING_ord);

	private OrderEnum() {
		enumValue(ASCENDING_ord, "ASCENDING");
		enumValue(DESCENDING_ord, "DESCENDING");
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
