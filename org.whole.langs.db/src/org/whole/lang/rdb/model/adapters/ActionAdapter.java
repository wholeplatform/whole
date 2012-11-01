package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.model.ActionEnum.Value;

/** 
 * @generator Whole
 */
public class ActionAdapter extends AbstractEntityAdapter implements Action {
	private static final long serialVersionUID = 1;

	public ActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ActionAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Action> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Action;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
