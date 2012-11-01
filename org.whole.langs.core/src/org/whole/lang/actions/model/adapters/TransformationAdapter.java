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
public class TransformationAdapter extends AbstractEntityAdapter implements
		Transformation {
	private static final long serialVersionUID = 1;

	public TransformationAdapter(IEntity implementor) {
		super(implementor);
	}

	public TransformationAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Transformation> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Transformation;
	}
}
