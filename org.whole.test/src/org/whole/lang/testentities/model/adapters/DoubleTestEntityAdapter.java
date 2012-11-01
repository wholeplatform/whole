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
public class DoubleTestEntityAdapter extends AbstractEntityAdapter implements
		DoubleTestEntity {
	private static final long serialVersionUID = 1;

	public DoubleTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public DoubleTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DoubleTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.DoubleTestEntity;
	}

	public double getValue() {
		return wDoubleValue();
	}

	public void setValue(double value) {
		wSetValue(value);
	}
}
