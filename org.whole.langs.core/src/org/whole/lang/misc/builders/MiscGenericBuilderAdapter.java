package org.whole.lang.misc.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MiscGenericBuilderAdapter extends GenericIdentityBuilder {
	private IMiscBuilder specificBuilder;

	public MiscGenericBuilderAdapter(IMiscBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public MiscGenericBuilderAdapter(IMiscBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case MiscEntityDescriptorEnum.Misc_ord:
			specificBuilder.Misc();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case MiscEntityDescriptorEnum.Misc_ord:
			specificBuilder.Misc_();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case MiscEntityDescriptorEnum.Misc_ord:
			specificBuilder.Misc_(initialCapacity);
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case MiscEntityDescriptorEnum.Misc_ord:
			specificBuilder._Misc();
			break;
		}
	}
}
