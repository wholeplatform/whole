package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class RegistryEnum extends EnumType<RegistryEnum.Value> {
	public static final int DEFAULT_ord = 0;
	public static final int STRICT_ord = 1;
	public static final int RESOLVER_ord = 2;
	public static final int ADAPTER_ord = 3;
	public static final int CUSTOM_ord = 4;
	public static final RegistryEnum instance = new RegistryEnum();
	public static final Value DEFAULT = instance.valueOf(DEFAULT_ord);
	public static final Value STRICT = instance.valueOf(STRICT_ord);
	public static final Value RESOLVER = instance.valueOf(RESOLVER_ord);
	public static final Value ADAPTER = instance.valueOf(ADAPTER_ord);
	public static final Value CUSTOM = instance.valueOf(CUSTOM_ord);

	private RegistryEnum() {
		enumValue(DEFAULT_ord, "DEFAULT");
		enumValue(STRICT_ord, "STRICT");
		enumValue(RESOLVER_ord, "RESOLVER");
		enumValue(ADAPTER_ord, "ADAPTER");
		enumValue(CUSTOM_ord, "CUSTOM");
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
