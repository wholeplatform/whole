package org.whole.lang.queries.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class PlacementEnum extends EnumType<PlacementEnum.Value> {
	public static final int BEFORE_ord = 0;
	public static final int INTO_ord = 1;
	public static final PlacementEnum instance = new PlacementEnum();
	public static final Value BEFORE = instance.valueOf(BEFORE_ord);
	public static final Value INTO = instance.valueOf(INTO_ord);

	private PlacementEnum() {
		enumValue(BEFORE_ord, "BEFORE");
		enumValue(INTO_ord, "INTO");
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
