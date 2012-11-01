package org.whole.lang.pojo.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/** 
 * @generator Whole
 */
public class CollectionInterfaceEnum extends
		EnumType<CollectionInterfaceEnum.Value> {
	public static final int Collection_ord = 0;
	public static final int List_ord = 1;
	public static final int Set_ord = 2;
	public static final CollectionInterfaceEnum instance = new CollectionInterfaceEnum();
	public static final Value Collection = instance.valueOf(Collection_ord);
	public static final Value List = instance.valueOf(List_ord);
	public static final Value Set = instance.valueOf(Set_ord);

	private CollectionInterfaceEnum() {
		enumValue(Collection_ord, "Collection");
		enumValue(List_ord, "List");
		enumValue(Set_ord, "Set");
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
