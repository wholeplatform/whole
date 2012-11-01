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
public class ColumnExpressionImpl extends AbstractSimpleEntity implements
		ColumnExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ColumnExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnExpression;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ColumnExpression_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private SQLExpression expression;

	public SQLExpression getExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(SQLExpression expression) {
		notifyChanged(SQLFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Alias alias;

	public Alias getAlias() {
		return notifyRequested(SQLFeatureDescriptorEnum.alias, alias);
	}

	public void setAlias(Alias alias) {
		notifyChanged(SQLFeatureDescriptorEnum.alias, this.alias,
				this.alias = alias);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getAlias().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 1:
			setAlias(value.wGetAdapter(SQLEntityDescriptorEnum.Alias));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
