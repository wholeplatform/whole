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
public class MenuActionsAdapter extends AbstractListEntityAdapter<Action>
		implements MenuActions {
	private static final long serialVersionUID = 1;

	public MenuActionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public MenuActionsAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MenuActions> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.MenuActions;
	}
}
