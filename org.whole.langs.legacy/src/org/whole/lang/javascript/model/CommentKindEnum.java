package org.whole.lang.javascript.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class CommentKindEnum extends EnumType<CommentKindEnum.Value> {
	public static final int line_ord = 0;
	public static final int block_ord = 1;
	public static final int jsdoc_ord = 2;
	public static final int html_ord = 3;
	public static final CommentKindEnum instance = new CommentKindEnum();
	public static final Value line = instance.valueOf(line_ord);
	public static final Value block = instance.valueOf(block_ord);
	public static final Value jsdoc = instance.valueOf(jsdoc_ord);
	public static final Value html = instance.valueOf(html_ord);

	private CommentKindEnum() {
		enumValue(line_ord, "line");
		enumValue(block_ord, "block");
		enumValue(jsdoc_ord, "jsdoc");
		enumValue(html_ord, "html");
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
