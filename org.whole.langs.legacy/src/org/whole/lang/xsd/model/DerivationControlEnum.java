package org.whole.lang.xsd.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class DerivationControlEnum extends
		EnumType<DerivationControlEnum.Value> {
	public static final int substitution_ord = 0;
	public static final int extension_ord = 1;
	public static final int restriction_ord = 2;
	public static final int list_ord = 3;
	public static final int union_ord = 4;
	public static final DerivationControlEnum instance = new DerivationControlEnum();
	public static final Value substitution = instance.valueOf(substitution_ord);
	public static final Value extension = instance.valueOf(extension_ord);
	public static final Value restriction = instance.valueOf(restriction_ord);
	public static final Value list = instance.valueOf(list_ord);
	public static final Value union = instance.valueOf(union_ord);

	private DerivationControlEnum() {
		enumValue(substitution_ord, "substitution");
		enumValue(extension_ord, "extension");
		enumValue(restriction_ord, "restriction");
		enumValue(list_ord, "list");
		enumValue(union_ord, "union");
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
