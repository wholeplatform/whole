package org.whole.lang.pojo.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class PrimitiveTypeEnum extends EnumType<PrimitiveTypeEnum.Value> {
	public static final int _boolean_ord = 0;
	public static final int _byte_ord = 1;
	public static final int _char_ord = 2;
	public static final int _double_ord = 3;
	public static final int _float_ord = 4;
	public static final int _int_ord = 5;
	public static final int _long_ord = 6;
	public static final int _short_ord = 7;
	public static final int String_ord = 8;
	public static final PrimitiveTypeEnum instance = new PrimitiveTypeEnum();
	public static final Value _boolean = instance.valueOf(_boolean_ord);
	public static final Value _byte = instance.valueOf(_byte_ord);
	public static final Value _char = instance.valueOf(_char_ord);
	public static final Value _double = instance.valueOf(_double_ord);
	public static final Value _float = instance.valueOf(_float_ord);
	public static final Value _int = instance.valueOf(_int_ord);
	public static final Value _long = instance.valueOf(_long_ord);
	public static final Value _short = instance.valueOf(_short_ord);
	public static final Value String = instance.valueOf(String_ord);

	private PrimitiveTypeEnum() {
		enumValue(_boolean_ord, "boolean", "_boolean");
		enumValue(_byte_ord, "byte", "_byte");
		enumValue(_char_ord, "char", "_char");
		enumValue(_double_ord, "double", "_double");
		enumValue(_float_ord, "float", "_float");
		enumValue(_int_ord, "int", "_int");
		enumValue(_long_ord, "long", "_long");
		enumValue(_short_ord, "short", "_short");
		enumValue(String_ord, "String");
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
