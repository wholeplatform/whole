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
public class BooleanTestEntityAdapter extends AbstractEntityAdapter implements
		BooleanTestEntity {
	private static final long serialVersionUID = 1;

	public BooleanTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.BooleanTestEntity;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
