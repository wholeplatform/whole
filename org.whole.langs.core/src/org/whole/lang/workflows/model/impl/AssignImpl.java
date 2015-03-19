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
public class AssignImpl extends AbstractSimpleEntity implements Assign {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Assign> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Assign;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.Assign_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Variable name;

	public Variable getName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public void setName(Variable name) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
