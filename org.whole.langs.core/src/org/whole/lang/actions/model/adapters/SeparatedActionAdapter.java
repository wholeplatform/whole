package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SeparatedActionAdapter extends AbstractEntityAdapter implements
		SeparatedAction {
	private static final long serialVersionUID = 1;

	public SeparatedActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SeparatedActionAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SeparatedAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.SeparatedAction;
	}

	public Action getAction() {
		return wGet(ActionsFeatureDescriptorEnum.action).wGetAdapter(
				ActionsEntityDescriptorEnum.Action);
	}

	public void setAction(Action action) {
		wSet(ActionsFeatureDescriptorEnum.action, action);
	}
}
