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
public class GroupActionImpl extends AbstractSimpleEntity implements
		GroupAction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<GroupAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.GroupAction;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.GroupAction_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Icon icon;

	public Icon getIcon() {
		return notifyRequested(ActionsFeatureDescriptorEnum.icon, icon);
	}

	public void setIcon(Icon icon) {
		notifyChanged(ActionsFeatureDescriptorEnum.icon, this.icon,
				this.icon = icon);
	}

	private Text text;

	public Text getText() {
		return notifyRequested(ActionsFeatureDescriptorEnum.text, text);
	}

	public void setText(Text text) {
		notifyChanged(ActionsFeatureDescriptorEnum.text, this.text,
				this.text = text);
	}

	private FillStrategy fillStrategy;

	public FillStrategy getFillStrategy() {
		return notifyRequested(ActionsFeatureDescriptorEnum.fillStrategy,
				fillStrategy);
	}

	public void setFillStrategy(FillStrategy fillStrategy) {
		notifyChanged(ActionsFeatureDescriptorEnum.fillStrategy,
				this.fillStrategy, this.fillStrategy = fillStrategy);
	}

	private Actions actions;

	public Actions getActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.actions, actions);
	}

	public void setActions(Actions actions) {
		notifyChanged(ActionsFeatureDescriptorEnum.actions, this.actions,
				this.actions = actions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIcon().wGetAdaptee(false);
		case 1:
			return getText().wGetAdaptee(false);
		case 2:
			return getFillStrategy().wGetAdaptee(false);
		case 3:
			return getActions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIcon(value.wGetAdapter(ActionsEntityDescriptorEnum.Icon));
			break;
		case 1:
			setText(value.wGetAdapter(ActionsEntityDescriptorEnum.Text));
			break;
		case 2:
			setFillStrategy(value
					.wGetAdapter(ActionsEntityDescriptorEnum.FillStrategy));
			break;
		case 3:
			setActions(value.wGetAdapter(ActionsEntityDescriptorEnum.Actions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
