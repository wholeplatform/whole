package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ICompositeEntityAdapter extends AbstractEntityAdapter implements
		ICompositeEntity {
	private static final long serialVersionUID = 1;

	public ICompositeEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public ICompositeEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ICompositeEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.ICompositeEntity;
	}
}
