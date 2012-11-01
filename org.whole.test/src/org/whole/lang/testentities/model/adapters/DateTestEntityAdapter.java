package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import java.util.Date;

/** 
 * @generator Whole
 */
public class DateTestEntityAdapter extends AbstractEntityAdapter implements
		DateTestEntity {
	private static final long serialVersionUID = 1;

	public DateTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public DateTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DateTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.DateTestEntity;
	}

	public Date getValue() {
		return wDateValue();
	}

	public void setValue(Date value) {
		wSetValue(value);
	}
}
