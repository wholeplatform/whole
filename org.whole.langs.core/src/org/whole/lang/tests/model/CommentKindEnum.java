package org.whole.lang.tests.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class CommentKindEnum extends EnumType<CommentKindEnum.Value> {
	public static final int NOTE_ord = 0;
	public static final int TODO_ord = 1;
	public static final int FIXME_ord = 2;
	public static final CommentKindEnum instance = new CommentKindEnum();
	public static final Value NOTE = instance.valueOf(NOTE_ord);
	public static final Value TODO = instance.valueOf(TODO_ord);
	public static final Value FIXME = instance.valueOf(FIXME_ord);

	private CommentKindEnum() {
		enumValue(NOTE_ord, "NOTE");
		enumValue(TODO_ord, "TODO");
		enumValue(FIXME_ord, "FIXME");
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
