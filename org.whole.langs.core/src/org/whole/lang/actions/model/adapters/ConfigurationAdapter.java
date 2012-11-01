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
public class ConfigurationAdapter extends AbstractEntityAdapter implements
		Configuration {
	private static final long serialVersionUID = 1;

	public ConfigurationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConfigurationAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Configuration> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Configuration;
	}

	public VariabilityModel getVariabilityModel() {
		return wGet(ActionsFeatureDescriptorEnum.variabilityModel).wGetAdapter(
				ActionsEntityDescriptorEnum.VariabilityModel);
	}

	public void setVariabilityModel(VariabilityModel variabilityModel) {
		wSet(ActionsFeatureDescriptorEnum.variabilityModel, variabilityModel);
	}

	public Predicate getValidator() {
		return wGet(ActionsFeatureDescriptorEnum.validator).wGetAdapter(
				ActionsEntityDescriptorEnum.Predicate);
	}

	public void setValidator(Predicate validator) {
		wSet(ActionsFeatureDescriptorEnum.validator, validator);
	}

	public Transformation getBindingsGenerator() {
		return wGet(ActionsFeatureDescriptorEnum.bindingsGenerator)
				.wGetAdapter(ActionsEntityDescriptorEnum.Transformation);
	}

	public void setBindingsGenerator(Transformation bindingsGenerator) {
		wSet(ActionsFeatureDescriptorEnum.bindingsGenerator, bindingsGenerator);
	}

	public Dialog getDialog() {
		return wGet(ActionsFeatureDescriptorEnum.dialog).wGetAdapter(
				ActionsEntityDescriptorEnum.Dialog);
	}

	public void setDialog(Dialog dialog) {
		wSet(ActionsFeatureDescriptorEnum.dialog, dialog);
	}
}
