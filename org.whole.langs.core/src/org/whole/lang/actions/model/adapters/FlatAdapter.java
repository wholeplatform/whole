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
public class FlatAdapter extends AbstractEntityAdapter implements Flat {
	private static final long serialVersionUID = 1;

	public FlatAdapter(IEntity implementor) {
		super(implementor);
	}

	public FlatAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Flat> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Flat;
	}
}
