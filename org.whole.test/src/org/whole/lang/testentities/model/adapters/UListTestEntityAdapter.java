package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class UListTestEntityAdapter extends
		AbstractListEntityAdapter<IStructuralEntity> implements UListTestEntity {
	private static final long serialVersionUID = 1;

	public UListTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public UListTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UListTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.UListTestEntity;
	}
}
