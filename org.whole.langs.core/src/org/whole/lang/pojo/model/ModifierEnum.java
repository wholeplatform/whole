package org.whole.lang.pojo.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ModifierEnum extends EnumType<ModifierEnum.Value> {
	public static final int ABSTRACT_ord = 0;
	public static final int DATATYPE_ord = 1;
	public static final int FIELD_ONLY_ord = 2;
	public static final int READ_ONLY_ord = 3;
	public static final int WRITE_ONLY_ord = 4;
	public static final ModifierEnum instance = new ModifierEnum();
	public static final Value ABSTRACT = instance.valueOf(ABSTRACT_ord);
	public static final Value DATATYPE = instance.valueOf(DATATYPE_ord);
	public static final Value FIELD_ONLY = instance.valueOf(FIELD_ONLY_ord);
	public static final Value READ_ONLY = instance.valueOf(READ_ONLY_ord);
	public static final Value WRITE_ONLY = instance.valueOf(WRITE_ONLY_ord);

	private ModifierEnum() {
		enumValue(ABSTRACT_ord, "ABSTRACT");
		enumValue(DATATYPE_ord, "DATATYPE");
		enumValue(FIELD_ONLY_ord, "FIELD_ONLY");
		enumValue(READ_ONLY_ord, "READ_ONLY");
		enumValue(WRITE_ONLY_ord, "WRITE_ONLY");
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
