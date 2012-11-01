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
public class FactoryActionAdapter extends AbstractEntityAdapter implements
		FactoryAction {
	private static final long serialVersionUID = 1;

	public FactoryActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public FactoryActionAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FactoryAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.FactoryAction;
	}

	public Transformation getTransformation() {
		return wGet(ActionsFeatureDescriptorEnum.transformation).wGetAdapter(
				ActionsEntityDescriptorEnum.Transformation);
	}

	public void setTransformation(Transformation transformation) {
		wSet(ActionsFeatureDescriptorEnum.transformation, transformation);
	}
}
