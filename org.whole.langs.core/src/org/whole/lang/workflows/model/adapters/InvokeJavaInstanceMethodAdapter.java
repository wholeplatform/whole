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
public class InvokeJavaInstanceMethodAdapter extends AbstractEntityAdapter
		implements InvokeJavaInstanceMethod {
	private static final long serialVersionUID = 1;

	public InvokeJavaInstanceMethodAdapter(IEntity implementor) {
		super(implementor);
	}

	public InvokeJavaInstanceMethodAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InvokeJavaInstanceMethod> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod;
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

	public Variable getObject() {
		return wGet(WorkflowsFeatureDescriptorEnum.object).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setObject(Variable object) {
		wSet(WorkflowsFeatureDescriptorEnum.object, object);
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

	public Expression getMethod() {
		return wGet(WorkflowsFeatureDescriptorEnum.method).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setMethod(Expression method) {
		wSet(WorkflowsFeatureDescriptorEnum.method, method);
	}

	public Expressions getArguments() {
		return wGet(WorkflowsFeatureDescriptorEnum.arguments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expressions);
	}

	public void setArguments(Expressions arguments) {
		wSet(WorkflowsFeatureDescriptorEnum.arguments, arguments);
	}
}
