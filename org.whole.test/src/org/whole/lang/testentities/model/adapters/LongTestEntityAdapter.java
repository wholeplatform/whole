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
public class LongTestEntityAdapter extends AbstractEntityAdapter implements
		LongTestEntity {
	private static final long serialVersionUID = 1;

	public LongTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public LongTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LongTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.LongTestEntity;
	}

	public long getValue() {
		return wLongValue();
	}

	public void setValue(long value) {
		wSetValue(value);
	}
}
