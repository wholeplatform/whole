package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.testentities.model.EnumTestEntityEnum.Value;

/** 
 * @generator Whole
 */
public class EnumTestEntityAdapter extends AbstractEntityAdapter implements
		EnumTestEntity {
	private static final long serialVersionUID = 1;

	public EnumTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnumTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnumTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.EnumTestEntity;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
