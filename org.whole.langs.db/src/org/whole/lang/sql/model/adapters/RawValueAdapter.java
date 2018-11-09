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
public class RawValueAdapter extends AbstractEntityAdapter implements RawValue {
	private static final long serialVersionUID = 1;

	public RawValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public RawValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RawValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.RawValue;
	}

	public Object getValue() {
		return (Object) wGetValue();
	}

	public void setValue(Object value) {
		wSetValue((Object) value);
	}
}
