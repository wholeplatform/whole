package org.whole.examples.datatypes.redblacktree.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ColorEnum extends EnumType<ColorEnum.Value> {
	public static final int BLACK_ord = 0;
	public static final int RED_ord = 1;
	public static final ColorEnum instance = new ColorEnum();
	public static final Value BLACK = instance.valueOf(BLACK_ord);
	public static final Value RED = instance.valueOf(RED_ord);

	private ColorEnum() {
		enumValue(BLACK_ord, "BLACK");
		enumValue(RED_ord, "RED");
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
