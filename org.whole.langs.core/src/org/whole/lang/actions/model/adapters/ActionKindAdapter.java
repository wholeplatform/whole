package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.model.ActionKindEnum.Value;

/** 
 * @generator Whole
 */
public class ActionKindAdapter extends AbstractEntityAdapter implements
		ActionKind {
	private static final long serialVersionUID = 1;

	public ActionKindAdapter(IEntity implementor) {
		super(implementor);
	}

	public ActionKindAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ActionKind> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ActionKind;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
