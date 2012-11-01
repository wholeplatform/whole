package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LoadJavaModelImpl extends AbstractSimpleEntity implements
		LoadJavaModel {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LoadJavaModel> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.LoadJavaModel;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.LoadJavaModel_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	private Label label;

	public Label getLabel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public void setLabel(Label label) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	private Variable model;

	public Variable getModel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.model, model);
	}

	public void setModel(Variable model) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.model, this.model,
				this.model = model);
	}

	private Expression className;

	public Expression getClassName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.className,
				className);
	}

	public void setClassName(Expression className) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.className, this.className,
				this.className = className);
	}

	private ClassProvider classProvider;

	public ClassProvider getClassProvider() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.classProvider,
				classProvider);
	}

	public void setClassProvider(ClassProvider classProvider) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.classProvider,
				this.classProvider, this.classProvider = classProvider);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getModel().wGetAdaptee(false);
		case 2:
			return getClassName().wGetAdaptee(false);
		case 3:
			return getClassProvider().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
			break;
		case 1:
			setModel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 2:
			setClassName(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		case 3:
			setClassProvider(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.ClassProvider));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
