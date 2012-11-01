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
public class TemplateActionImpl extends AbstractSimpleEntity implements
		TemplateAction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TemplateAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.TemplateAction;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.TemplateAction_ord;
	}

	public void accept(IActionsVisitor visitor) {
		visitor.visit(this);
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

	private ActionKind kind;

	public ActionKind getKind() {
		return notifyRequested(ActionsFeatureDescriptorEnum.kind, kind);
	}

	public void setKind(ActionKind kind) {
		notifyChanged(ActionsFeatureDescriptorEnum.kind, this.kind,
				this.kind = kind);
	}

	private Predicate enablerPredicate;

	public Predicate getEnablerPredicate() {
		return notifyRequested(ActionsFeatureDescriptorEnum.enablerPredicate,
				enablerPredicate);
	}

	public void setEnablerPredicate(Predicate enablerPredicate) {
		notifyChanged(ActionsFeatureDescriptorEnum.enablerPredicate,
				this.enablerPredicate, this.enablerPredicate = enablerPredicate);
	}

	private Configuration configuration;

	public Configuration getConfiguration() {
		return notifyRequested(ActionsFeatureDescriptorEnum.configuration,
				configuration);
	}

	public void setConfiguration(Configuration configuration) {
		notifyChanged(ActionsFeatureDescriptorEnum.configuration,
				this.configuration, this.configuration = configuration);
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
			return getIcon().wGetAdaptee(false);
		case 1:
			return getText().wGetAdaptee(false);
		case 2:
			return getKind().wGetAdaptee(false);
		case 3:
			return getEnablerPredicate().wGetAdaptee(false);
		case 4:
			return getConfiguration().wGetAdaptee(false);
		case 5:
			return getTransformation().wGetAdaptee(false);
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
			setKind(value.wGetAdapter(ActionsEntityDescriptorEnum.ActionKind));
			break;
		case 3:
			setEnablerPredicate(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Predicate));
			break;
		case 4:
			setConfiguration(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Configuration));
			break;
		case 5:
			setTransformation(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Transformation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
