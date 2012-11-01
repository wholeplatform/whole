package org.whole.lang.grammars.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class CategoryEnum extends EnumType<CategoryEnum.Value> {
	public static final int DELIMITER_ord = 0;
	public static final int IDENTIFIER_ord = 1;
	public static final int KEYWORD_ord = 2;
	public static final int LITERAL_ord = 3;
	public static final int OPERATOR_ord = 4;
	public static final int PARENTHESIS_ord = 5;
	public static final int SEPARATOR_ord = 6;
	public static final CategoryEnum instance = new CategoryEnum();
	public static final Value DELIMITER = instance.valueOf(DELIMITER_ord);
	public static final Value IDENTIFIER = instance.valueOf(IDENTIFIER_ord);
	public static final Value KEYWORD = instance.valueOf(KEYWORD_ord);
	public static final Value LITERAL = instance.valueOf(LITERAL_ord);
	public static final Value OPERATOR = instance.valueOf(OPERATOR_ord);
	public static final Value PARENTHESIS = instance.valueOf(PARENTHESIS_ord);
	public static final Value SEPARATOR = instance.valueOf(SEPARATOR_ord);

	private CategoryEnum() {
		enumValue(DELIMITER_ord, "DELIMITER");
		enumValue(IDENTIFIER_ord, "IDENTIFIER");
		enumValue(KEYWORD_ord, "KEYWORD");
		enumValue(LITERAL_ord, "LITERAL");
		enumValue(OPERATOR_ord, "OPERATOR");
		enumValue(PARENTHESIS_ord, "PARENTHESIS");
		enumValue(SEPARATOR_ord, "SEPARATOR");
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
