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
public class NamingStrategyAdapter extends AbstractEntityAdapter implements
		NamingStrategy {
	private static final long serialVersionUID = 1;

	public NamingStrategyAdapter(IEntity implementor) {
		super(implementor);
	}

	public NamingStrategyAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NamingStrategy> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.NamingStrategy;
	}
}
