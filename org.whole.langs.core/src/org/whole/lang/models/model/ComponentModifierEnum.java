package org.whole.lang.models.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ComponentModifierEnum extends
		EnumType<ComponentModifierEnum.Value> {
	public static final int ordered_ord = 0;
	public static final int unique_ord = 1;
	public static final int reference_ord = 2;
	public static final int derived_ord = 3;
	public static final int shared_ord = 4;
	public static final ComponentModifierEnum instance = new ComponentModifierEnum();
	public static final Value ordered = instance.valueOf(ordered_ord);
	public static final Value unique = instance.valueOf(unique_ord);
	public static final Value reference = instance.valueOf(reference_ord);
	public static final Value derived = instance.valueOf(derived_ord);
	public static final Value shared = instance.valueOf(shared_ord);

	private ComponentModifierEnum() {
		enumValue(ordered_ord, "ordered");
		enumValue(unique_ord, "unique");
		enumValue(reference_ord, "reference");
		enumValue(derived_ord, "derived");
		enumValue(shared_ord, "shared");
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
