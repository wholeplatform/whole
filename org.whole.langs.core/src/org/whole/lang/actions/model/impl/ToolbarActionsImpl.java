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
public class ToolbarActionsImpl extends AbstractSimpleEntity implements
		ToolbarActions {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ToolbarActions> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ToolbarActions;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.ToolbarActions_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SimpleAction validatorAction;

	public SimpleAction getValidatorAction() {
		return notifyRequested(ActionsFeatureDescriptorEnum.validatorAction,
				validatorAction);
	}

	public void setValidatorAction(SimpleAction validatorAction) {
		notifyChanged(ActionsFeatureDescriptorEnum.validatorAction,
				this.validatorAction, this.validatorAction = validatorAction);
	}

	private SimpleAction normalizerAction;

	public SimpleAction getNormalizerAction() {
		return notifyRequested(ActionsFeatureDescriptorEnum.normalizerAction,
				normalizerAction);
	}

	public void setNormalizerAction(SimpleAction normalizerAction) {
		notifyChanged(ActionsFeatureDescriptorEnum.normalizerAction,
				this.normalizerAction, this.normalizerAction = normalizerAction);
	}

	private SimpleAction prettyPrinterAction;

	public SimpleAction getPrettyPrinterAction() {
		return notifyRequested(
				ActionsFeatureDescriptorEnum.prettyPrinterAction,
				prettyPrinterAction);
	}

	public void setPrettyPrinterAction(SimpleAction prettyPrinterAction) {
		notifyChanged(ActionsFeatureDescriptorEnum.prettyPrinterAction,
				this.prettyPrinterAction,
				this.prettyPrinterAction = prettyPrinterAction);
	}

	private SimpleAction interpreterAction;

	public SimpleAction getInterpreterAction() {
		return notifyRequested(ActionsFeatureDescriptorEnum.interpreterAction,
				interpreterAction);
	}

	public void setInterpreterAction(SimpleAction interpreterAction) {
		notifyChanged(ActionsFeatureDescriptorEnum.interpreterAction,
				this.interpreterAction,
				this.interpreterAction = interpreterAction);
	}

	private SimpleAction generatorAction;

	public SimpleAction getGeneratorAction() {
		return notifyRequested(ActionsFeatureDescriptorEnum.generatorAction,
				generatorAction);
	}

	public void setGeneratorAction(SimpleAction generatorAction) {
		notifyChanged(ActionsFeatureDescriptorEnum.generatorAction,
				this.generatorAction, this.generatorAction = generatorAction);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getValidatorAction().wGetAdaptee(false);
		case 1:
			return getNormalizerAction().wGetAdaptee(false);
		case 2:
			return getPrettyPrinterAction().wGetAdaptee(false);
		case 3:
			return getInterpreterAction().wGetAdaptee(false);
		case 4:
			return getGeneratorAction().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setValidatorAction(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction));
			break;
		case 1:
			setNormalizerAction(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction));
			break;
		case 2:
			setPrettyPrinterAction(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction));
			break;
		case 3:
			setInterpreterAction(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction));
			break;
		case 4:
			setGeneratorAction(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
