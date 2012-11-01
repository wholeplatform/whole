package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FunctionExpressionAdapter extends AbstractEntityAdapter implements
		FunctionExpression {
	private static final long serialVersionUID = 1;

	public FunctionExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionExpressionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.FunctionExpression;
	}

	public FunctionName getFunctionName() {
		return wGet(SQLFeatureDescriptorEnum.functionName).wGetAdapter(
				SQLEntityDescriptorEnum.FunctionName);
	}

	public void setFunctionName(FunctionName functionName) {
		wSet(SQLFeatureDescriptorEnum.functionName, functionName);
	}

	public SQLExpressions getParams() {
		return wGet(SQLFeatureDescriptorEnum.params).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpressions);
	}

	public void setParams(SQLExpressions params) {
		wSet(SQLFeatureDescriptorEnum.params, params);
	}
}
