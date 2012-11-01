package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.model.OrderEnum.Value;

/** 
 * @generator Whole
 */
public class OrderAdapter extends AbstractEntityAdapter implements Order {
	private static final long serialVersionUID = 1;

	public OrderAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrderAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Order> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Order;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
