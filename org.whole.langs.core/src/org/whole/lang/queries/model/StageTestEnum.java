package org.whole.lang.queries.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class StageTestEnum extends EnumType<StageTestEnum.Value> {
	public static final int HOST_STAGE_ord = 0;
	public static final int HOST_STAGE_0_ord = 1;
	public static final int TEMPLATE_STAGE_1_ord = 2;
	public static final int TEMPLATE_STAGE_ord = 3;
	public static final StageTestEnum instance = new StageTestEnum();
	public static final Value HOST_STAGE = instance.valueOf(HOST_STAGE_ord);
	public static final Value HOST_STAGE_0 = instance.valueOf(HOST_STAGE_0_ord);
	public static final Value TEMPLATE_STAGE_1 = instance
			.valueOf(TEMPLATE_STAGE_1_ord);
	public static final Value TEMPLATE_STAGE = instance
			.valueOf(TEMPLATE_STAGE_ord);

	private StageTestEnum() {
		enumValue(HOST_STAGE_ord, "HOST_STAGE");
		enumValue(HOST_STAGE_0_ord, "HOST_STAGE_0");
		enumValue(TEMPLATE_STAGE_1_ord, "TEMPLATE_STAGE_1");
		enumValue(TEMPLATE_STAGE_ord, "TEMPLATE_STAGE");
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
