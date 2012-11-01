package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FunctionApplicationAdapter extends AbstractEntityAdapter implements
		FunctionApplication {
	private static final long serialVersionUID = 1;

	public FunctionApplicationAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionApplicationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionApplication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionApplication;
	}

	public Function getFunction() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.function).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Function);
	}

	public void setFunction(Function function) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.function, function);
	}

	public Arguments getArguments() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.arguments)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.arguments, arguments);
	}

	public Term getResult() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.result).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Term);
	}

	public void setResult(Term result) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.result, result);
	}
}
