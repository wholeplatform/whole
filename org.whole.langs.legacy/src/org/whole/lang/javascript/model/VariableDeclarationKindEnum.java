package org.whole.lang.javascript.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class VariableDeclarationKindEnum extends
		EnumType<VariableDeclarationKindEnum.Value> {
	public static final int var_ord = 0;
	public static final int let_ord = 1;
	public static final int _const_ord = 2;
	public static final VariableDeclarationKindEnum instance = new VariableDeclarationKindEnum();
	public static final Value var = instance.valueOf(var_ord);
	public static final Value let = instance.valueOf(let_ord);
	public static final Value _const = instance.valueOf(_const_ord);

	private VariableDeclarationKindEnum() {
		enumValue(var_ord, "var");
		enumValue(let_ord, "let");
		enumValue(_const_ord, "const", "_const");
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
