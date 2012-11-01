package org.whole.lang.environment.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import java.util.Date;

/** 
 * @generator Whole
 */
public class DateDataAdapter extends AbstractEntityAdapter implements DateData {
	private static final long serialVersionUID = 1;

	public DateDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public DateDataAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DateData> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.DateData;
	}

	public Date getValue() {
		return wDateValue();
	}

	public void setValue(Date value) {
		wSetValue(value);
	}
}
