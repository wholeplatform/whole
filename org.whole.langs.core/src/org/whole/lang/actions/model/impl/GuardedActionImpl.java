package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class GuardedActionImpl extends AbstractSimpleEntity implements
		GuardedAction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<GuardedAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.GuardedAction;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.GuardedAction_ord;
	}

	public void accept(IActionsVisitor visitor) {
		visitor.visit(this);
	}

	private Label name;

	public Label getName() {
		return notifyRequested(ActionsFeatureDescriptorEnum.name, name);
	}

	public void setName(Label name) {
		notifyChanged(ActionsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Transformation transformation;

	public Transformation getTransformation() {
		return notifyRequested(ActionsFeatureDescriptorEnum.transformation,
				transformation);
	}

	public void setTransformation(Transformation transformation) {
		notifyChanged(ActionsFeatureDescriptorEnum.transformation,
				this.transformation, this.transformation = transformation);
	}

	private Predicate enablerPredicate;

	public Predicate getEnablerPredicate() {
		return notifyRequested(ActionsFeatureDescriptorEnum.enablerPredicate,
				enablerPredicate);
	}

	public void setEnablerPredicate(Predicate enablerPredicate) {
		notifyChanged(ActionsFeatureDescriptorEnum.enablerPredicate,
				this.enablerPredicate, this.enablerPredicate = enablerPredicate);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getTransformation().wGetAdaptee(false);
		case 2:
			return getEnablerPredicate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ActionsEntityDescriptorEnum.Label));
			break;
		case 1:
			setTransformation(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Transformation));
			break;
		case 2:
			setEnablerPredicate(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Predicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
