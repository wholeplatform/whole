package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.IfElseStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Statement;

/** 
 * @generator Whole
 */
public class IfElseStatementImpl extends AbstractSimpleEntity implements IfElseStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IfElseStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.IfElseStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.IfElseStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression condition;

	public Expression getCondition() {
		return notifyRequested(ImpFeatureDescriptorEnum.condition, condition);
	}

	public void setCondition(Expression condition) {
		notifyChanged(ImpFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
	}

	private Statement trueBody;

	public Statement getTrueBody() {
		return notifyRequested(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public void setTrueBody(Statement trueBody) {
		notifyChanged(ImpFeatureDescriptorEnum.trueBody, this.trueBody, this.trueBody = trueBody);
	}

	private Statement falseBody;

	public Statement getFalseBody() {
		return notifyRequested(ImpFeatureDescriptorEnum.falseBody, falseBody);
	}

	public void setFalseBody(Statement falseBody) {
		notifyChanged(ImpFeatureDescriptorEnum.falseBody, this.falseBody, this.falseBody = falseBody);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCondition().wGetAdaptee(false);
		case 1:
			return getTrueBody().wGetAdaptee(false);
		case 2:
			return getFalseBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCondition(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 1:
			setTrueBody(value.wGetAdapter(ImpEntityDescriptorEnum.Statement));
			break;
		case 2:
			setFalseBody(value.wGetAdapter(ImpEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
