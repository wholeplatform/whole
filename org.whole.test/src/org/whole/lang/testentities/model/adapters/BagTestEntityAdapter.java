package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BagTestEntityAdapter extends
		AbstractCollectionEntityAdapter<ITestEntity> implements BagTestEntity {
	private static final long serialVersionUID = 1;

	public BagTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public BagTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BagTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.BagTestEntity;
	}
}
