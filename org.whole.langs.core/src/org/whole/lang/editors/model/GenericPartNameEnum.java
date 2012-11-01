package org.whole.lang.editors.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class GenericPartNameEnum extends EnumType<GenericPartNameEnum.Value> {
	public static final int CompositeColumn_ord = 0;
	public static final int CompositeRow_ord = 1;
	public static final int ConstructorColumn_ord = 2;
	public static final int ConstructorRow_ord = 3;
	public static final int FoldableConstructor_ord = 4;
	public static final int Resolver_ord = 5;
	public static final int OptionalResolver_ord = 6;
	public static final int LiteralData_ord = 7;
	public static final int KeywordData_ord = 8;
	public static final int IdentifierData_ord = 9;
	public static final int OperatorData_ord = 10;
	public static final int DelimiterData_ord = 11;
	public static final int ParenthesisData_ord = 12;
	public static final GenericPartNameEnum instance = new GenericPartNameEnum();
	public static final Value CompositeColumn = instance
			.valueOf(CompositeColumn_ord);
	public static final Value CompositeRow = instance.valueOf(CompositeRow_ord);
	public static final Value ConstructorColumn = instance
			.valueOf(ConstructorColumn_ord);
	public static final Value ConstructorRow = instance
			.valueOf(ConstructorRow_ord);
	public static final Value FoldableConstructor = instance
			.valueOf(FoldableConstructor_ord);
	public static final Value Resolver = instance.valueOf(Resolver_ord);
	public static final Value OptionalResolver = instance
			.valueOf(OptionalResolver_ord);
	public static final Value LiteralData = instance.valueOf(LiteralData_ord);
	public static final Value KeywordData = instance.valueOf(KeywordData_ord);
	public static final Value IdentifierData = instance
			.valueOf(IdentifierData_ord);
	public static final Value OperatorData = instance.valueOf(OperatorData_ord);
	public static final Value DelimiterData = instance
			.valueOf(DelimiterData_ord);
	public static final Value ParenthesisData = instance
			.valueOf(ParenthesisData_ord);

	private GenericPartNameEnum() {
		enumValue(CompositeColumn_ord, "CompositeColumn");
		enumValue(CompositeRow_ord, "CompositeRow");
		enumValue(ConstructorColumn_ord, "ConstructorColumn");
		enumValue(ConstructorRow_ord, "ConstructorRow");
		enumValue(FoldableConstructor_ord, "FoldableConstructor");
		enumValue(Resolver_ord, "Resolver");
		enumValue(OptionalResolver_ord, "OptionalResolver");
		enumValue(LiteralData_ord, "LiteralData");
		enumValue(KeywordData_ord, "KeywordData");
		enumValue(IdentifierData_ord, "IdentifierData");
		enumValue(OperatorData_ord, "OperatorData");
		enumValue(DelimiterData_ord, "DelimiterData");
		enumValue(ParenthesisData_ord, "ParenthesisData");
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
