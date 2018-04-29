package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FunctionInvocationExpressionAdapter extends AbstractEntityAdapter implements FunctionInvocationExpression {
	private static final long serialVersionUID = 1;

	public FunctionInvocationExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionInvocationExpressionAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionInvocationExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.FunctionInvocationExpression;
	}

	public NameExpression getName() {
		return wGet(ImpFeatureDescriptorEnum.name).wGetAdapter(ImpEntityDescriptorEnum.NameExpression);
	}

	public void setName(NameExpression name) {
		wSet(ImpFeatureDescriptorEnum.name, name);
	}

	public Arguments getArguments() {
		return wGet(ImpFeatureDescriptorEnum.arguments).wGetAdapter(ImpEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(ImpFeatureDescriptorEnum.arguments, arguments);
	}
}
