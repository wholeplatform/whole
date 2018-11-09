package org.whole.lang.sql.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ReferenceTypeEnum extends EnumType<ReferenceTypeEnum.Value> {
	public static final int TYPE_ord = 0;
	public static final int ROWTYPE_ord = 1;
	public static final ReferenceTypeEnum instance = new ReferenceTypeEnum();
	public static final Value TYPE = instance.valueOf(TYPE_ord);
	public static final Value ROWTYPE = instance.valueOf(ROWTYPE_ord);

	private ReferenceTypeEnum() {
		enumValue(TYPE_ord, "TYPE");
		enumValue(ROWTYPE_ord, "ROWTYPE");
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
