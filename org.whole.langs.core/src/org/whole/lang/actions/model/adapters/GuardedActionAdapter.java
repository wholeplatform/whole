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
public class GuardedActionAdapter extends AbstractEntityAdapter implements
		GuardedAction {
	private static final long serialVersionUID = 1;

	public GuardedActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public GuardedActionAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<GuardedAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.GuardedAction;
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

	public Predicate getEnablerPredicate() {
		return wGet(ActionsFeatureDescriptorEnum.enablerPredicate).wGetAdapter(
				ActionsEntityDescriptorEnum.Predicate);
	}

	public void setEnablerPredicate(Predicate enablerPredicate) {
		wSet(ActionsFeatureDescriptorEnum.enablerPredicate, enablerPredicate);
	}
}
