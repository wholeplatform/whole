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
public class IStructuralEntityAdapter extends AbstractEntityAdapter implements
		IStructuralEntity {
	private static final long serialVersionUID = 1;

	public IStructuralEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public IStructuralEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IStructuralEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.IStructuralEntity;
	}
}
