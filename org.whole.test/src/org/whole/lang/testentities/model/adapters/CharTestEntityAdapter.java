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
public class CharTestEntityAdapter extends AbstractEntityAdapter implements
		CharTestEntity {
	private static final long serialVersionUID = 1;

	public CharTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public CharTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CharTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.CharTestEntity;
	}

	public char getValue() {
		return wCharValue();
	}

	public void setValue(char value) {
		wSetValue(value);
	}
}
