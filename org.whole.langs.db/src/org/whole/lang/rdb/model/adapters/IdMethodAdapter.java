package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.model.IdMethodEnum.Value;

/** 
 * @generator Whole
 */
public class IdMethodAdapter extends AbstractEntityAdapter implements IdMethod {
	private static final long serialVersionUID = 1;

	public IdMethodAdapter(IEntity implementor) {
		super(implementor);
	}

	public IdMethodAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IdMethod> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.IdMethod;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
