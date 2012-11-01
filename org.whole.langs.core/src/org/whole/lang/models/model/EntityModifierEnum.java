package org.whole.lang.models.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class EntityModifierEnum extends EnumType<EntityModifierEnum.Value> {
	public static final int _abstract_ord = 0;
	public static final int relationship_ord = 1;
	public static final EntityModifierEnum instance = new EntityModifierEnum();
	public static final Value _abstract = instance.valueOf(_abstract_ord);
	public static final Value relationship = instance.valueOf(relationship_ord);

	private EntityModifierEnum() {
		enumValue(_abstract_ord, "abstract", "_abstract");
		enumValue(relationship_ord, "relationship");
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
