package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ResourceKindEnum extends EnumType<ResourceKindEnum.Value> {
	public static final int FILE_SYSTEM_ord = 0;
	public static final int WORKSPACE_ord = 1;
	public static final int CLASSPATH_ord = 2;
	public static final int URL_ord = 3;
	public static final int VARIABLE_ord = 4;
	public static final ResourceKindEnum instance = new ResourceKindEnum();
	public static final Value FILE_SYSTEM = instance.valueOf(FILE_SYSTEM_ord);
	public static final Value WORKSPACE = instance.valueOf(WORKSPACE_ord);
	public static final Value CLASSPATH = instance.valueOf(CLASSPATH_ord);
	public static final Value URL = instance.valueOf(URL_ord);
	public static final Value VARIABLE = instance.valueOf(VARIABLE_ord);

	private ResourceKindEnum() {
		enumValue(FILE_SYSTEM_ord, "FILE_SYSTEM");
		enumValue(WORKSPACE_ord, "WORKSPACE");
		enumValue(CLASSPATH_ord, "CLASSPATH");
		enumValue(URL_ord, "URL");
		enumValue(VARIABLE_ord, "VARIABLE");
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
