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
public class SubgroupActionAdapter extends AbstractEntityAdapter implements
		SubgroupAction {
	private static final long serialVersionUID = 1;

	public SubgroupActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubgroupActionAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SubgroupAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.SubgroupAction;
	}

	public Icon getIcon() {
		return wGet(ActionsFeatureDescriptorEnum.icon).wGetAdapter(
				ActionsEntityDescriptorEnum.Icon);
	}

	public void setIcon(Icon icon) {
		wSet(ActionsFeatureDescriptorEnum.icon, icon);
	}

	public Text getText() {
		return wGet(ActionsFeatureDescriptorEnum.text).wGetAdapter(
				ActionsEntityDescriptorEnum.Text);
	}

	public void setText(Text text) {
		wSet(ActionsFeatureDescriptorEnum.text, text);
	}

	public FillStrategy getFillStrategy() {
		return wGet(ActionsFeatureDescriptorEnum.fillStrategy).wGetAdapter(
				ActionsEntityDescriptorEnum.FillStrategy);
	}

	public void setFillStrategy(FillStrategy fillStrategy) {
		wSet(ActionsFeatureDescriptorEnum.fillStrategy, fillStrategy);
	}

	public Actions getActions() {
		return wGet(ActionsFeatureDescriptorEnum.actions).wGetAdapter(
				ActionsEntityDescriptorEnum.Actions);
	}

	public void setActions(Actions actions) {
		wSet(ActionsFeatureDescriptorEnum.actions, actions);
	}
}
