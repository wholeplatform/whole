package org.whole.lang.builders;

import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

public class ModelFeaturesBuilder extends GenericBuilderContext {
	public ModelFeaturesBuilder(final Features features) {
		super(new GenericIdentityBuilder());
		wSetBuilderStrategy(new GenericIdentityBuilder() {

			@Override
			public void wEntity_(EntityDescriptor<?> ed) {
				if (ModelsEntityDescriptorEnum.Feature.equals(ed))
					wBuildEntity_(ed);
			}

			@Override
			public void _wEntity(EntityDescriptor<?> ed) {
				if (ModelsEntityDescriptorEnum.Feature.equals(ed)) {
					Feature f = (Feature) _wBuildEntity(ed);
					features.wAdd(f);
				}
			}
		});
	}
}
