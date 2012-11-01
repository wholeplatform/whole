package org.whole.lang.javascript.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class XmlMemberOperatorEnum extends
		EnumType<XmlMemberOperatorEnum.Value> {
	public static final int dot_ord = 0;
	public static final int dotdot_ord = 1;
	public static final XmlMemberOperatorEnum instance = new XmlMemberOperatorEnum();
	public static final Value dot = instance.valueOf(dot_ord);
	public static final Value dotdot = instance.valueOf(dotdot_ord);

	private XmlMemberOperatorEnum() {
		enumValue(dot_ord, "dot");
		enumValue(dotdot_ord, "dotdot");
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
