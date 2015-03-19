package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SeparatedActionImpl extends AbstractSimpleEntity implements
		SeparatedAction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SeparatedAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.SeparatedAction;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.SeparatedAction_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Action action;

	public Action getAction() {
		return notifyRequested(ActionsFeatureDescriptorEnum.action, action);
	}

	public void setAction(Action action) {
		notifyChanged(ActionsFeatureDescriptorEnum.action, this.action,
				this.action = action);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAction().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAction(value.wGetAdapter(ActionsEntityDescriptorEnum.Action));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
