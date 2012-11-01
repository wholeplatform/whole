package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FeaturePathAdapter extends AbstractEntityAdapter implements
		FeaturePath {
	private static final long serialVersionUID = 1;

	public FeaturePathAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeaturePathAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeaturePath> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FeaturePath;
	}
}
