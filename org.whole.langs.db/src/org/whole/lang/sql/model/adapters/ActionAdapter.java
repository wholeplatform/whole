package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.model.ActionEnum.Value;

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

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Action> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Action;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
