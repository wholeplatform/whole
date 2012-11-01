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
public class CreateJavaClassInstanceAdapter extends AbstractEntityAdapter
		implements CreateJavaClassInstance {
	private static final long serialVersionUID = 1;

	public CreateJavaClassInstanceAdapter(IEntity implementor) {
		super(implementor);
	}

	public CreateJavaClassInstanceAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CreateJavaClassInstance> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.CreateJavaClassInstance;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Variable getResult() {
		return wGet(WorkflowsFeatureDescriptorEnum.result).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setResult(Variable result) {
		wSet(WorkflowsFeatureDescriptorEnum.result, result);
	}

	public Expressions getTypeArguments() {
		return wGet(WorkflowsFeatureDescriptorEnum.typeArguments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expressions);
	}

	public void setTypeArguments(Expressions typeArguments) {
		wSet(WorkflowsFeatureDescriptorEnum.typeArguments, typeArguments);
	}

	public Expression getClassName() {
		return wGet(WorkflowsFeatureDescriptorEnum.className).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setClassName(Expression className) {
		wSet(WorkflowsFeatureDescriptorEnum.className, className);
	}

	public Expression getConstructor() {
		return wGet(WorkflowsFeatureDescriptorEnum.constructor).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setConstructor(Expression constructor) {
		wSet(WorkflowsFeatureDescriptorEnum.constructor, constructor);
	}

	public Expressions getArguments() {
		return wGet(WorkflowsFeatureDescriptorEnum.arguments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expressions);
	}

	public void setArguments(Expressions arguments) {
		wSet(WorkflowsFeatureDescriptorEnum.arguments, arguments);
	}
}
