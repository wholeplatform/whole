package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ColumnIndexAdapter extends AbstractEntityAdapter implements
		ColumnIndex {
	private static final long serialVersionUID = 1;

	public ColumnIndexAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnIndexAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnIndex> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnIndex;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public Order getOrder() {
		return wGet(RDBFeatureDescriptorEnum.order).wGetAdapter(
				RDBEntityDescriptorEnum.Order);
	}

	public void setOrder(Order order) {
		wSet(RDBFeatureDescriptorEnum.order, order);
	}
}
