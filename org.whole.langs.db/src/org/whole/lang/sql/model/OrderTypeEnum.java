package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class OrderTypeEnum extends EnumType<OrderTypeEnum.Value> {
	public static final int ASC_ord = 0;
	public static final int DESC_ord = 1;
	public static final OrderTypeEnum instance = new OrderTypeEnum();
	public static final Value ASC = instance.valueOf(ASC_ord);
	public static final Value DESC = instance.valueOf(DESC_ord);

	private OrderTypeEnum() {
		enumValue(ASC_ord, "ASC");
		enumValue(DESC_ord, "DESC");
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
