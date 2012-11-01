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
public class FunctionExpressionImpl extends AbstractSimpleEntity implements
		FunctionExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.FunctionExpression;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.FunctionExpression_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private FunctionName functionName;

	public FunctionName getFunctionName() {
		return notifyRequested(SQLFeatureDescriptorEnum.functionName,
				functionName);
	}

	public void setFunctionName(FunctionName functionName) {
		notifyChanged(SQLFeatureDescriptorEnum.functionName, this.functionName,
				this.functionName = functionName);
	}

	private SQLExpressions params;

	public SQLExpressions getParams() {
		return notifyRequested(SQLFeatureDescriptorEnum.params, params);
	}

	public void setParams(SQLExpressions params) {
		notifyChanged(SQLFeatureDescriptorEnum.params, this.params,
				this.params = params);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFunctionName().wGetAdaptee(false);
		case 1:
			return getParams().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFunctionName(value
					.wGetAdapter(SQLEntityDescriptorEnum.FunctionName));
			break;
		case 1:
			setParams(value.wGetAdapter(SQLEntityDescriptorEnum.SQLExpressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
