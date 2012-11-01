package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SetTestEntityAdapter extends AbstractSetEntityAdapter<ITestEntity>
		implements SetTestEntity {
	private static final long serialVersionUID = 1;

	public SetTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public SetTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SetTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.SetTestEntity;
	}
}
