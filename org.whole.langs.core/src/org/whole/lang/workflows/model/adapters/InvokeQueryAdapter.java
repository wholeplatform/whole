package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class InvokeQueryAdapter extends AbstractEntityAdapter implements
		InvokeQuery {
	private static final long serialVersionUID = 1;

	public InvokeQueryAdapter(IEntity implementor) {
		super(implementor);
	}

	public InvokeQueryAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InvokeQuery> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.InvokeQuery;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Variable getQueryName() {
		return wGet(WorkflowsFeatureDescriptorEnum.queryName).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setQueryName(Variable queryName) {
		wSet(WorkflowsFeatureDescriptorEnum.queryName, queryName);
	}

	public Arguments getArguments() {
		return wGet(WorkflowsFeatureDescriptorEnum.arguments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(WorkflowsFeatureDescriptorEnum.arguments, arguments);
	}
}
