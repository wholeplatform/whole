package org.whole.lang.misc.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MiscSpecificBuilderAdapter extends GenericBuilderContext implements
		IMiscBuilder {
	public MiscSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public MiscSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void visit() {
	}

	public void Misc() {
		wEntity(MiscEntityDescriptorEnum.Misc);
	}

	public void Misc_() {
		wEntity_(MiscEntityDescriptorEnum.Misc);
	}

	public void Misc_(int initialCapacity) {
		wEntity_(MiscEntityDescriptorEnum.Misc, initialCapacity);
	}

	public void _Misc() {
		_wEntity(MiscEntityDescriptorEnum.Misc);
	}
}
