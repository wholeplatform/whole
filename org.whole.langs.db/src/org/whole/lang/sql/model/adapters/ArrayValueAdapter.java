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
public class ArrayValueAdapter extends AbstractEntityAdapter implements ArrayValue {
	private static final long serialVersionUID = 1;

	public ArrayValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ArrayValue;
	}

	public Object getValue() {
		return (Object) wGetValue();
	}

	public void setValue(Object value) {
		wSetValue((Object) value);
	}
}
