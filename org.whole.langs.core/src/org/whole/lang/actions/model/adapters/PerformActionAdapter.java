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
public class PerformActionAdapter extends AbstractEntityAdapter implements
		PerformAction {
	private static final long serialVersionUID = 1;

	public PerformActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public PerformActionAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PerformAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.PerformAction;
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

	public ActionKind getKind() {
		return wGet(ActionsFeatureDescriptorEnum.kind).wGetAdapter(
				ActionsEntityDescriptorEnum.ActionKind);
	}

	public void setKind(ActionKind kind) {
		wSet(ActionsFeatureDescriptorEnum.kind, kind);
	}

	public Predicate getEnablerPredicate() {
		return wGet(ActionsFeatureDescriptorEnum.enablerPredicate).wGetAdapter(
				ActionsEntityDescriptorEnum.Predicate);
	}

	public void setEnablerPredicate(Predicate enablerPredicate) {
		wSet(ActionsFeatureDescriptorEnum.enablerPredicate, enablerPredicate);
	}

	public Configuration getConfiguration() {
		return wGet(ActionsFeatureDescriptorEnum.configuration).wGetAdapter(
				ActionsEntityDescriptorEnum.Configuration);
	}

	public void setConfiguration(Configuration configuration) {
		wSet(ActionsFeatureDescriptorEnum.configuration, configuration);
	}

	public Transformation getTransformation() {
		return wGet(ActionsFeatureDescriptorEnum.transformation).wGetAdapter(
				ActionsEntityDescriptorEnum.Transformation);
	}

	public void setTransformation(Transformation transformation) {
		wSet(ActionsFeatureDescriptorEnum.transformation, transformation);
	}
}
