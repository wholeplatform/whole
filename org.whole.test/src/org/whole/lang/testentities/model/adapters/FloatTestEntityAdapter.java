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
public class FloatTestEntityAdapter extends AbstractEntityAdapter implements
		FloatTestEntity {
	private static final long serialVersionUID = 1;

	public FloatTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public FloatTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FloatTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.FloatTestEntity;
	}

	public float getValue() {
		return wFloatValue();
	}

	public void setValue(float value) {
		wSetValue(value);
	}
}
