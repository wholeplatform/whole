package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ArtifactsSynchronizeStrategyEnum extends
		EnumType<ArtifactsSynchronizeStrategyEnum.Value> {
	public static final int REMOVE_ADD_UPDATE_ord = 0;
	public static final int ADD_UPDATE_ord = 1;
	public static final int UPDATE_ord = 2;
	public static final ArtifactsSynchronizeStrategyEnum instance = new ArtifactsSynchronizeStrategyEnum();
	public static final Value REMOVE_ADD_UPDATE = instance
			.valueOf(REMOVE_ADD_UPDATE_ord);
	public static final Value ADD_UPDATE = instance.valueOf(ADD_UPDATE_ord);
	public static final Value UPDATE = instance.valueOf(UPDATE_ord);

	private ArtifactsSynchronizeStrategyEnum() {
		enumValue(REMOVE_ADD_UPDATE_ord, "REMOVE_ADD_UPDATE");
		enumValue(ADD_UPDATE_ord, "ADD_UPDATE");
		enumValue(UPDATE_ord, "UPDATE");
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
