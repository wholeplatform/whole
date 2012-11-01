package org.whole.lang.xsd.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class WhiteSpaceProcessingEnum extends
		EnumType<WhiteSpaceProcessingEnum.Value> {
	public static final int preserve_ord = 0;
	public static final int replace_ord = 1;
	public static final int collapse_ord = 2;
	public static final WhiteSpaceProcessingEnum instance = new WhiteSpaceProcessingEnum();
	public static final Value preserve = instance.valueOf(preserve_ord);
	public static final Value replace = instance.valueOf(replace_ord);
	public static final Value collapse = instance.valueOf(collapse_ord);

	private WhiteSpaceProcessingEnum() {
		enumValue(preserve_ord, "preserve");
		enumValue(replace_ord, "replace");
		enumValue(collapse_ord, "collapse");
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
