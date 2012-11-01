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
public class ActionCallImpl extends AbstractSimpleEntity implements ActionCall {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ActionCall> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ActionCall;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.ActionCall_ord;
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

	private SelectedEntities selectedEntities;

	public SelectedEntities getSelectedEntities() {
		return notifyRequested(ActionsFeatureDescriptorEnum.selectedEntities,
				selectedEntities);
	}

	public void setSelectedEntities(SelectedEntities selectedEntities) {
		notifyChanged(ActionsFeatureDescriptorEnum.selectedEntities,
				this.selectedEntities, this.selectedEntities = selectedEntities);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getSelectedEntities().wGetAdaptee(false);
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
			setSelectedEntities(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SelectedEntities));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
