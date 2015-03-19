package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FunctionApplicationImpl extends AbstractSimpleEntity implements
		FunctionApplication {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionApplication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionApplication;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionApplication_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Function function;

	public Function getFunction() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.function,
				function);
	}

	public void setFunction(Function function) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.function,
				this.function, this.function = function);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.arguments,
				this.arguments, this.arguments = arguments);
	}

	private Term result;

	public Term getResult() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.result,
				result);
	}

	public void setResult(Term result) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.result, this.result,
				this.result = result);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFunction().wGetAdaptee(false);
		case 1:
			return getArguments().wGetAdaptee(false);
		case 2:
			return getResult().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFunction(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Function));
			break;
		case 1:
			setArguments(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Arguments));
			break;
		case 2:
			setResult(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Term));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
