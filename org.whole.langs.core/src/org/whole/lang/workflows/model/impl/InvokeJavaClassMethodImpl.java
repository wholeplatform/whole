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
public class InvokeJavaClassMethodImpl extends AbstractSimpleEntity implements
		InvokeJavaClassMethod {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InvokeJavaClassMethod> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod_ord;
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

	private Variable result;

	public Variable getResult() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.result, result);
	}

	public void setResult(Variable result) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.result, this.result,
				this.result = result);
	}

	private Expressions typeArguments;

	public Expressions getTypeArguments() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.typeArguments,
				typeArguments);
	}

	public void setTypeArguments(Expressions typeArguments) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.typeArguments,
				this.typeArguments, this.typeArguments = typeArguments);
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

	private Expression method;

	public Expression getMethod() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.method, method);
	}

	public void setMethod(Expression method) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.method, this.method,
				this.method = method);
	}

	private Expressions arguments;

	public Expressions getArguments() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Expressions arguments) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getResult().wGetAdaptee(false);
		case 2:
			return getTypeArguments().wGetAdaptee(false);
		case 3:
			return getClassName().wGetAdaptee(false);
		case 4:
			return getMethod().wGetAdaptee(false);
		case 5:
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
			setResult(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 2:
			setTypeArguments(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expressions));
			break;
		case 3:
			setClassName(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		case 4:
			setMethod(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		case 5:
			setArguments(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
