package org.whole.examples.lang.imp.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class PrimitiveTypeEnum extends EnumType<PrimitiveTypeEnum.Value> {
	public static final int _boolean_ord = 0;
	public static final int _int_ord = 1;
	public static final int string_ord = 2;
	public static final int entity_ord = 3;
	public static final int function_ord = 4;
	public static final int _void_ord = 5;
	public static final PrimitiveTypeEnum instance = new PrimitiveTypeEnum();
	public static final Value _boolean = instance.valueOf(_boolean_ord);
	public static final Value _int = instance.valueOf(_int_ord);
	public static final Value string = instance.valueOf(string_ord);
	public static final Value entity = instance.valueOf(entity_ord);
	public static final Value function = instance.valueOf(function_ord);
	public static final Value _void = instance.valueOf(_void_ord);

	private PrimitiveTypeEnum() {
		enumValue(_boolean_ord, "boolean", "_boolean");
		enumValue(_int_ord, "int", "_int");
		enumValue(string_ord, "string");
		enumValue(entity_ord, "entity");
		enumValue(function_ord, "function");
		enumValue(_void_ord, "void", "_void");
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
