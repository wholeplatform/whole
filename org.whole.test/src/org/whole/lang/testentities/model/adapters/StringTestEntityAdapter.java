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
public class StringTestEntityAdapter extends AbstractEntityAdapter implements
		StringTestEntity {
	private static final long serialVersionUID = 1;

	public StringTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.StringTestEntity;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
