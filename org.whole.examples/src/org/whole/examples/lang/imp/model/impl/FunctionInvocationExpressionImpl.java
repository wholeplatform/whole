package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.FunctionInvocationExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.NameExpression;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Arguments;

/** 
 * @generator Whole
 */
public class FunctionInvocationExpressionImpl extends AbstractSimpleEntity implements FunctionInvocationExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionInvocationExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.FunctionInvocationExpression;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.FunctionInvocationExpression_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private NameExpression name;

	public NameExpression getName() {
		return notifyRequested(ImpFeatureDescriptorEnum.name, name);
	}

	public void setName(NameExpression name) {
		notifyChanged(ImpFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(ImpFeatureDescriptorEnum.arguments, arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(ImpFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ImpEntityDescriptorEnum.NameExpression));
			break;
		case 1:
			setArguments(value.wGetAdapter(ImpEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
