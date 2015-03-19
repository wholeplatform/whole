package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class InImpl extends AbstractSimpleEntity implements In {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<In> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.In;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.In_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SQLExpression leftExpr;

	public SQLExpression getLeftExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.leftExpr, leftExpr);
	}

	public void setLeftExpr(SQLExpression leftExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.leftExpr, this.leftExpr,
				this.leftExpr = leftExpr);
	}

	private InPredicate inPredicate;

	public InPredicate getInPredicate() {
		return notifyRequested(SQLFeatureDescriptorEnum.inPredicate,
				inPredicate);
	}

	public void setInPredicate(InPredicate inPredicate) {
		notifyChanged(SQLFeatureDescriptorEnum.inPredicate, this.inPredicate,
				this.inPredicate = inPredicate);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftExpr().wGetAdaptee(false);
		case 1:
			return getInPredicate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeftExpr(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 1:
			setInPredicate(value
					.wGetAdapter(SQLEntityDescriptorEnum.InPredicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
