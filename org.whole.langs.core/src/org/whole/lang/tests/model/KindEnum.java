package org.whole.lang.tests.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class KindEnum extends EnumType<KindEnum.Value> {
	public static final int SIMPLE_ord = 0;
	public static final int COMPOSITE_ord = 1;
	public static final int DATA_ord = 2;
	public static final int RESOLVER_ord = 3;
	public static final int PROXY_ord = 4;
	public static final int ADAPTER_ord = 5;
	public static final int IMPL_ord = 6;
	public static final int VARIABLE_ord = 7;
	public static final int FRAGMENT_ord = 8;
	public static final int SAME_STAGE_FRAGMENT_ord = 9;
	public static final int STAGE_UP_FRAGMENT_ord = 10;
	public static final int STAGE_DOWN_FRAGMENT_ord = 11;
	public static final KindEnum instance = new KindEnum();
	public static final Value SIMPLE = instance.valueOf(SIMPLE_ord);
	public static final Value COMPOSITE = instance.valueOf(COMPOSITE_ord);
	public static final Value DATA = instance.valueOf(DATA_ord);
	public static final Value RESOLVER = instance.valueOf(RESOLVER_ord);
	public static final Value PROXY = instance.valueOf(PROXY_ord);
	public static final Value ADAPTER = instance.valueOf(ADAPTER_ord);
	public static final Value IMPL = instance.valueOf(IMPL_ord);
	public static final Value VARIABLE = instance.valueOf(VARIABLE_ord);
	public static final Value FRAGMENT = instance.valueOf(FRAGMENT_ord);
	public static final Value SAME_STAGE_FRAGMENT = instance
			.valueOf(SAME_STAGE_FRAGMENT_ord);
	public static final Value STAGE_UP_FRAGMENT = instance
			.valueOf(STAGE_UP_FRAGMENT_ord);
	public static final Value STAGE_DOWN_FRAGMENT = instance
			.valueOf(STAGE_DOWN_FRAGMENT_ord);

	private KindEnum() {
		enumValue(SIMPLE_ord, "SIMPLE");
		enumValue(COMPOSITE_ord, "COMPOSITE");
		enumValue(DATA_ord, "DATA");
		enumValue(RESOLVER_ord, "RESOLVER");
		enumValue(PROXY_ord, "PROXY");
		enumValue(ADAPTER_ord, "ADAPTER");
		enumValue(IMPL_ord, "IMPL");
		enumValue(VARIABLE_ord, "VARIABLE");
		enumValue(FRAGMENT_ord, "FRAGMENT");
		enumValue(SAME_STAGE_FRAGMENT_ord, "SAME_STAGE_FRAGMENT");
		enumValue(STAGE_UP_FRAGMENT_ord, "STAGE_UP_FRAGMENT");
		enumValue(STAGE_DOWN_FRAGMENT_ord, "STAGE_DOWN_FRAGMENT");
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
