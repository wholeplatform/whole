package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.model.OrderTypeEnum.Value;

/** 
 * @generator Whole
 */
public class OrderTypeAdapter extends AbstractEntityAdapter implements OrderType {
	private static final long serialVersionUID = 1;

	public OrderTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrderTypeAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OrderType> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.OrderType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
