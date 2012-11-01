package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class OperationEnum extends EnumType<OperationEnum.Value> {
	public static final int VALIDATOR_ord = 0;
	public static final int NORMALIZER_ord = 1;
	public static final int INTERPRETER_ord = 2;
	public static final int PRETTY_PRINTER_ord = 3;
	public static final int ARTIFACTS_GENERATOR_ord = 4;
	public static final int JAVA_COMPILER_ord = 5;
	public static final OperationEnum instance = new OperationEnum();
	public static final Value VALIDATOR = instance.valueOf(VALIDATOR_ord);
	public static final Value NORMALIZER = instance.valueOf(NORMALIZER_ord);
	public static final Value INTERPRETER = instance.valueOf(INTERPRETER_ord);
	public static final Value PRETTY_PRINTER = instance
			.valueOf(PRETTY_PRINTER_ord);
	public static final Value ARTIFACTS_GENERATOR = instance
			.valueOf(ARTIFACTS_GENERATOR_ord);
	public static final Value JAVA_COMPILER = instance
			.valueOf(JAVA_COMPILER_ord);

	private OperationEnum() {
		enumValue(VALIDATOR_ord, "VALIDATOR");
		enumValue(NORMALIZER_ord, "NORMALIZER");
		enumValue(INTERPRETER_ord, "INTERPRETER");
		enumValue(PRETTY_PRINTER_ord, "PRETTY_PRINTER");
		enumValue(ARTIFACTS_GENERATOR_ord, "ARTIFACTS_GENERATOR");
		enumValue(JAVA_COMPILER_ord, "JAVA_COMPILER");
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
