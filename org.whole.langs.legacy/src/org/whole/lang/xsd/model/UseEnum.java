package org.whole.lang.xsd.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class UseEnum extends EnumType<UseEnum.Value> {
	public static final int optional_ord = 0;
	public static final int prohibited_ord = 1;
	public static final int required_ord = 2;
	public static final UseEnum instance = new UseEnum();
	public static final Value optional = instance.valueOf(optional_ord);
	public static final Value prohibited = instance.valueOf(prohibited_ord);
	public static final Value required = instance.valueOf(required_ord);

	private UseEnum() {
		enumValue(optional_ord, "optional");
		enumValue(prohibited_ord, "prohibited");
		enumValue(required_ord, "required");
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
