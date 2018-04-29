package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.DoWhileStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Statement;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Expression;

/** 
 * @generator Whole
 */
public class DoWhileStatementImpl extends AbstractSimpleEntity implements DoWhileStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DoWhileStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.DoWhileStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.DoWhileStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Statement trueBody;

	public Statement getTrueBody() {
		return notifyRequested(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public void setTrueBody(Statement trueBody) {
		notifyChanged(ImpFeatureDescriptorEnum.trueBody, this.trueBody, this.trueBody = trueBody);
	}

	private Expression condition;

	public Expression getCondition() {
		return notifyRequested(ImpFeatureDescriptorEnum.condition, condition);
	}

	public void setCondition(Expression condition) {
		notifyChanged(ImpFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTrueBody().wGetAdaptee(false);
		case 1:
			return getCondition().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTrueBody(value.wGetAdapter(ImpEntityDescriptorEnum.Statement));
			break;
		case 1:
			setCondition(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
