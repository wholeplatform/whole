package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FeaturesAdapter extends AbstractListEntityAdapter<Feature>
		implements Features {
	private static final long serialVersionUID = 1;

	public FeaturesAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeaturesAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Features> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Features;
	}
}
