package org.whole.lang.models.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class FeatureModifierEnum extends EnumType<FeatureModifierEnum.Value> {
	public static final int optional_ord = 0;
	public static final int id_ord = 1;
	public static final int reference_ord = 2;
	public static final int derived_ord = 3;
	public static final int shared_ord = 4;
	public static final FeatureModifierEnum instance = new FeatureModifierEnum();
	public static final Value optional = instance.valueOf(optional_ord);
	public static final Value id = instance.valueOf(id_ord);
	public static final Value reference = instance.valueOf(reference_ord);
	public static final Value derived = instance.valueOf(derived_ord);
	public static final Value shared = instance.valueOf(shared_ord);

	private FeatureModifierEnum() {
		enumValue(optional_ord, "optional");
		enumValue(id_ord, "id");
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
