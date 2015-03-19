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
public class FactoryActionImpl extends AbstractSimpleEntity implements
		FactoryAction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FactoryAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.FactoryAction;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.FactoryAction_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTransformation().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTransformation(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Transformation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
