package org.whole.lang.artifacts.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class AttributeEnum extends EnumType<AttributeEnum.Value> {
	public static final int derived_ord = 0;
	public static final int readonly_ord = 1;
	public static final int merge_ord = 2;
	public static final int source_ord = 3;
	public static final AttributeEnum instance = new AttributeEnum();
	public static final Value derived = instance.valueOf(derived_ord);
	public static final Value readonly = instance.valueOf(readonly_ord);
	public static final Value merge = instance.valueOf(merge_ord);
	public static final Value source = instance.valueOf(source_ord);

	private AttributeEnum() {
		enumValue(derived_ord, "derived");
		enumValue(readonly_ord, "readonly");
		enumValue(merge_ord, "merge");
		enumValue(source_ord, "source");
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
