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
public class ByteTestEntityAdapter extends AbstractEntityAdapter implements
		ByteTestEntity {
	private static final long serialVersionUID = 1;

	public ByteTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public ByteTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ByteTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.ByteTestEntity;
	}

	public byte getValue() {
		return wByteValue();
	}

	public void setValue(byte value) {
		wSetValue(value);
	}
}
