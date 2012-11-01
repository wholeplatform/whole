package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DistinctPrefixAdapter extends AbstractEntityAdapter implements
		DistinctPrefix {
	private static final long serialVersionUID = 1;

	public DistinctPrefixAdapter(IEntity implementor) {
		super(implementor);
	}

	public DistinctPrefixAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DistinctPrefix> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.DistinctPrefix;
	}
}
