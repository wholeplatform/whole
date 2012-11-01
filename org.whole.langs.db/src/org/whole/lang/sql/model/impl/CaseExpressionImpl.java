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
public class CaseExpressionImpl extends AbstractSimpleEntity implements
		CaseExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CaseExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.CaseExpression;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.CaseExpression_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private WhenClauses whenClauses;

	public WhenClauses getWhenClauses() {
		return notifyRequested(SQLFeatureDescriptorEnum.whenClauses,
				whenClauses);
	}

	public void setWhenClauses(WhenClauses whenClauses) {
		notifyChanged(SQLFeatureDescriptorEnum.whenClauses, this.whenClauses,
				this.whenClauses = whenClauses);
	}

	private SQLExpression elseClause;

	public SQLExpression getElseClause() {
		return notifyRequested(SQLFeatureDescriptorEnum.elseClause, elseClause);
	}

	public void setElseClause(SQLExpression elseClause) {
		notifyChanged(SQLFeatureDescriptorEnum.elseClause, this.elseClause,
				this.elseClause = elseClause);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getWhenClauses().wGetAdaptee(false);
		case 1:
			return getElseClause().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setWhenClauses(value
					.wGetAdapter(SQLEntityDescriptorEnum.WhenClauses));
			break;
		case 1:
			setElseClause(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
