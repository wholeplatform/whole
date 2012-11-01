package org.whole.lang.javascript.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class PostfixOperatorEnum extends EnumType<PostfixOperatorEnum.Value> {
	public static final int decrement_ord = 0;
	public static final int increment_ord = 1;
	public static final PostfixOperatorEnum instance = new PostfixOperatorEnum();
	public static final Value decrement = instance.valueOf(decrement_ord);
	public static final Value increment = instance.valueOf(increment_ord);

	private PostfixOperatorEnum() {
		enumValue(decrement_ord, "decrement");
		enumValue(increment_ord, "increment");
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
