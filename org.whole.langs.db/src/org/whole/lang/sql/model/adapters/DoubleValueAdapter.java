package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DoubleValueAdapter extends AbstractEntityAdapter implements
		DoubleValue {
	private static final long serialVersionUID = 1;

	public DoubleValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public DoubleValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DoubleValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DoubleValue;
	}

	public double getValue() {
		return wDoubleValue();
	}

	public void setValue(double value) {
		wSetValue(value);
	}
}
