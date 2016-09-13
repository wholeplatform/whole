package org.whole.lang.misc.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.misc.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class MiscEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Misc_ord = 0;
	public static final int Any_ord = 1;
	public static final MiscEntityDescriptorEnum instance = new MiscEntityDescriptorEnum();
	public static final EntityDescriptor<Misc> Misc = (EntityDescriptor<Misc>) instance
			.valueOf(Misc_ord);
	public static final EntityDescriptor<Any> Any = (EntityDescriptor<Any>) instance
			.valueOf(Any_ord);

	private MiscEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putCompositeEntity(
		Misc_ord, "Misc", Misc.class, false, Any_ord, true, false);
		putSimpleEntity(Any_ord, "Any", Any.class, true);
	}

	protected void initForeignTypeRelations() {
		setAssignableFromAll(true, Any_ord);
	}
}
