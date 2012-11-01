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
public class ShortTestEntityAdapter extends AbstractEntityAdapter implements
		ShortTestEntity {
	private static final long serialVersionUID = 1;

	public ShortTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public ShortTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ShortTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.ShortTestEntity;
	}

	public short getValue() {
		return wShortValue();
	}

	public void setValue(short value) {
		wSetValue(value);
	}
}
