package org.whole.lang.misc.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.misc.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MiscEntityFactory extends GenericEntityFactory {
	public static final MiscEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static MiscEntityFactory instance(IEntityRegistryProvider provider) {
		return new MiscEntityFactory(provider);
	}

	protected MiscEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Misc createMisc() {
		return create(MiscEntityDescriptorEnum.Misc);
	}

	public Misc createMisc(Any... entities) {
		return create(MiscEntityDescriptorEnum.Misc, (IEntity[]) entities);
	}

	public Misc createMisc(int initialSize) {
		return clone(MiscEntityDescriptorEnum.Misc, initialSize);
	}
}
