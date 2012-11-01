package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class WhileStatementImpl extends AbstractSimpleEntity implements
		WhileStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<WhileStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.WhileStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.WhileStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		visitor.visit(this);
	}

	private Expression condition;

	public Expression getCondition() {
		return notifyRequested(ImpFeatureDescriptorEnum.condition, condition);
	}

	public void setCondition(Expression condition) {
		notifyChanged(ImpFeatureDescriptorEnum.condition, this.condition,
				this.condition = condition);
	}

	private Statement trueBody;

	public Statement getTrueBody() {
		return notifyRequested(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public void setTrueBody(Statement trueBody) {
		notifyChanged(ImpFeatureDescriptorEnum.trueBody, this.trueBody,
				this.trueBody = trueBody);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCondition().wGetAdaptee(false);
		case 1:
			return getTrueBody().wGetAdaptee(false);
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
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
