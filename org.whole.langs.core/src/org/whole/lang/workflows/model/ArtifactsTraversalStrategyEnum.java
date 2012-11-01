package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class ArtifactsTraversalStrategyEnum extends
		EnumType<ArtifactsTraversalStrategyEnum.Value> {
	public static final int SHALLOW_ord = 0;
	public static final int DEEP_DIRECTORY_ord = 1;
	public static final int DEEP_FILE_ord = 2;
	public static final int DEEP_ord = 3;
	public static final ArtifactsTraversalStrategyEnum instance = new ArtifactsTraversalStrategyEnum();
	public static final Value SHALLOW = instance.valueOf(SHALLOW_ord);
	public static final Value DEEP_DIRECTORY = instance
			.valueOf(DEEP_DIRECTORY_ord);
	public static final Value DEEP_FILE = instance.valueOf(DEEP_FILE_ord);
	public static final Value DEEP = instance.valueOf(DEEP_ord);

	private ArtifactsTraversalStrategyEnum() {
		enumValue(SHALLOW_ord, "SHALLOW");
		enumValue(DEEP_DIRECTORY_ord, "DEEP_DIRECTORY");
		enumValue(DEEP_FILE_ord, "DEEP_FILE");
		enumValue(DEEP_ord, "DEEP");
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
