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
public class ConfigurationImpl extends AbstractSimpleEntity implements
		Configuration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Configuration> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Configuration;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.Configuration_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private VariabilityModel variabilityModel;

	public VariabilityModel getVariabilityModel() {
		return notifyRequested(ActionsFeatureDescriptorEnum.variabilityModel,
				variabilityModel);
	}

	public void setVariabilityModel(VariabilityModel variabilityModel) {
		notifyChanged(ActionsFeatureDescriptorEnum.variabilityModel,
				this.variabilityModel, this.variabilityModel = variabilityModel);
	}

	private Predicate validator;

	public Predicate getValidator() {
		return notifyRequested(ActionsFeatureDescriptorEnum.validator,
				validator);
	}

	public void setValidator(Predicate validator) {
		notifyChanged(ActionsFeatureDescriptorEnum.validator, this.validator,
				this.validator = validator);
	}

	private Transformation bindingsGenerator;

	public Transformation getBindingsGenerator() {
		return notifyRequested(ActionsFeatureDescriptorEnum.bindingsGenerator,
				bindingsGenerator);
	}

	public void setBindingsGenerator(Transformation bindingsGenerator) {
		notifyChanged(ActionsFeatureDescriptorEnum.bindingsGenerator,
				this.bindingsGenerator,
				this.bindingsGenerator = bindingsGenerator);
	}

	private Dialog dialog;

	public Dialog getDialog() {
		return notifyRequested(ActionsFeatureDescriptorEnum.dialog, dialog);
	}

	public void setDialog(Dialog dialog) {
		notifyChanged(ActionsFeatureDescriptorEnum.dialog, this.dialog,
				this.dialog = dialog);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getVariabilityModel().wGetAdaptee(false);
		case 1:
			return getValidator().wGetAdaptee(false);
		case 2:
			return getBindingsGenerator().wGetAdaptee(false);
		case 3:
			return getDialog().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVariabilityModel(value
					.wGetAdapter(ActionsEntityDescriptorEnum.VariabilityModel));
			break;
		case 1:
			setValidator(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Predicate));
			break;
		case 2:
			setBindingsGenerator(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Transformation));
			break;
		case 3:
			setDialog(value.wGetAdapter(ActionsEntityDescriptorEnum.Dialog));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
