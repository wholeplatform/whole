package org.whole.lang.xsd.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class QualifyEnum extends EnumType<QualifyEnum.Value> {
	public static final int unqualified_ord = 0;
	public static final int qualified_ord = 1;
	public static final QualifyEnum instance = new QualifyEnum();
	public static final Value unqualified = instance.valueOf(unqualified_ord);
	public static final Value qualified = instance.valueOf(qualified_ord);

	private QualifyEnum() {
		enumValue(unqualified_ord, "unqualified");
		enumValue(qualified_ord, "qualified");
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
