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
public class BooleanValueAdapter extends AbstractEntityAdapter implements BooleanValue {
	private static final long serialVersionUID = 1;

	public BooleanValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BooleanValue;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
