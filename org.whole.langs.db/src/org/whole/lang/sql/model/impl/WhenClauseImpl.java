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
public class WhenClauseImpl extends AbstractSimpleEntity implements WhenClause {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<WhenClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.WhenClause;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.WhenClause_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private BooleanExpression condition;

	public BooleanExpression getCondition() {
		return notifyRequested(SQLFeatureDescriptorEnum.condition, condition);
	}

	public void setCondition(BooleanExpression condition) {
		notifyChanged(SQLFeatureDescriptorEnum.condition, this.condition,
				this.condition = condition);
	}

	private SQLExpression result;

	public SQLExpression getResult() {
		return notifyRequested(SQLFeatureDescriptorEnum.result, result);
	}

	public void setResult(SQLExpression result) {
		notifyChanged(SQLFeatureDescriptorEnum.result, this.result,
				this.result = result);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCondition().wGetAdaptee(false);
		case 1:
			return getResult().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCondition(value
					.wGetAdapter(SQLEntityDescriptorEnum.BooleanExpression));
			break;
		case 1:
			setResult(value.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
