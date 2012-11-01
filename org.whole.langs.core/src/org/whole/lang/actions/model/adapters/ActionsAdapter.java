package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ActionsAdapter extends AbstractListEntityAdapter<Action> implements
		Actions {
	private static final long serialVersionUID = 1;

	public ActionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ActionsAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Actions> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Actions;
	}
}
