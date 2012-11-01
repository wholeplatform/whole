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
public class IntTestEntityAdapter extends AbstractEntityAdapter implements
		IntTestEntity {
	private static final long serialVersionUID = 1;

	public IntTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IntTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.IntTestEntity;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
