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
public class BinaryValueAdapter extends AbstractEntityAdapter implements
		BinaryValue {
	private static final long serialVersionUID = 1;

	public BinaryValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public BinaryValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BinaryValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BinaryValue;
	}

	public Object getValue() {
		return (Object) wGetValue();
	}

	public void setValue(Object value) {
		wSetValue((Object) value);
	}
}
