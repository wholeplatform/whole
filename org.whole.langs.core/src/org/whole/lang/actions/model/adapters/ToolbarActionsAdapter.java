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
public class ToolbarActionsAdapter extends AbstractEntityAdapter implements
		ToolbarActions {
	private static final long serialVersionUID = 1;

	public ToolbarActionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ToolbarActionsAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ToolbarActions> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ToolbarActions;
	}

	public SimpleAction getValidatorAction() {
		return wGet(ActionsFeatureDescriptorEnum.validatorAction).wGetAdapter(
				ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void setValidatorAction(SimpleAction validatorAction) {
		wSet(ActionsFeatureDescriptorEnum.validatorAction, validatorAction);
	}

	public SimpleAction getNormalizerAction() {
		return wGet(ActionsFeatureDescriptorEnum.normalizerAction).wGetAdapter(
				ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void setNormalizerAction(SimpleAction normalizerAction) {
		wSet(ActionsFeatureDescriptorEnum.normalizerAction, normalizerAction);
	}

	public SimpleAction getPrettyPrinterAction() {
		return wGet(ActionsFeatureDescriptorEnum.prettyPrinterAction)
				.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void setPrettyPrinterAction(SimpleAction prettyPrinterAction) {
		wSet(ActionsFeatureDescriptorEnum.prettyPrinterAction,
				prettyPrinterAction);
	}

	public SimpleAction getInterpreterAction() {
		return wGet(ActionsFeatureDescriptorEnum.interpreterAction)
				.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void setInterpreterAction(SimpleAction interpreterAction) {
		wSet(ActionsFeatureDescriptorEnum.interpreterAction, interpreterAction);
	}

	public SimpleAction getGeneratorAction() {
		return wGet(ActionsFeatureDescriptorEnum.generatorAction).wGetAdapter(
				ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void setGeneratorAction(SimpleAction generatorAction) {
		wSet(ActionsFeatureDescriptorEnum.generatorAction, generatorAction);
	}
}
