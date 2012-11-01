package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class TestTimeEnum extends EnumType<TestTimeEnum.Value> {
	public static final int before_ord = 0;
	public static final int after_ord = 1;
	public static final TestTimeEnum instance = new TestTimeEnum();
	public static final Value before = instance.valueOf(before_ord);
	public static final Value after = instance.valueOf(after_ord);

	private TestTimeEnum() {
		enumValue(before_ord, "before");
		enumValue(after_ord, "after");
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
