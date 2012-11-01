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
public class InvokeQueryImpl extends AbstractSimpleEntity implements
		InvokeQuery {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InvokeQuery> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.InvokeQuery;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.InvokeQuery_ord;
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

	private Variable queryName;

	public Variable getQueryName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.queryName,
				queryName);
	}

	public void setQueryName(Variable queryName) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.queryName, this.queryName,
				this.queryName = queryName);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getQueryName().wGetAdaptee(false);
		case 2:
			return getArguments().wGetAdaptee(false);
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
			setQueryName(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 2:
			setArguments(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
