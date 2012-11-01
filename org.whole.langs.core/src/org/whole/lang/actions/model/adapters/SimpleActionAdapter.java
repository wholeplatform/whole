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
public class SimpleActionAdapter extends AbstractEntityAdapter implements
		SimpleAction {
	private static final long serialVersionUID = 1;

	public SimpleActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleActionAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.SimpleAction;
	}

	public Label getName() {
		return wGet(ActionsFeatureDescriptorEnum.name).wGetAdapter(
				ActionsEntityDescriptorEnum.Label);
	}

	public void setName(Label name) {
		wSet(ActionsFeatureDescriptorEnum.name, name);
	}

	public Transformation getTransformation() {
		return wGet(ActionsFeatureDescriptorEnum.transformation).wGetAdapter(
				ActionsEntityDescriptorEnum.Transformation);
	}

	public void setTransformation(Transformation transformation) {
		wSet(ActionsFeatureDescriptorEnum.transformation, transformation);
	}
}
