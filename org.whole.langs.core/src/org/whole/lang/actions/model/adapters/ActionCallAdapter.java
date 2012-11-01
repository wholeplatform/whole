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
public class ActionCallAdapter extends AbstractEntityAdapter implements
		ActionCall {
	private static final long serialVersionUID = 1;

	public ActionCallAdapter(IEntity implementor) {
		super(implementor);
	}

	public ActionCallAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ActionCall> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ActionCall;
	}

	public Label getName() {
		return wGet(ActionsFeatureDescriptorEnum.name).wGetAdapter(
				ActionsEntityDescriptorEnum.Label);
	}

	public void setName(Label name) {
		wSet(ActionsFeatureDescriptorEnum.name, name);
	}

	public SelectedEntities getSelectedEntities() {
		return wGet(ActionsFeatureDescriptorEnum.selectedEntities).wGetAdapter(
				ActionsEntityDescriptorEnum.SelectedEntities);
	}

	public void setSelectedEntities(SelectedEntities selectedEntities) {
		wSet(ActionsFeatureDescriptorEnum.selectedEntities, selectedEntities);
	}
}
