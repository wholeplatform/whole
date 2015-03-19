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
public class FunctionDefinitionImpl extends AbstractSimpleEntity implements
		FunctionDefinition {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionDefinition> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionDefinition;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionDefinition_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SimpleFunction function;

	public SimpleFunction getFunction() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.function,
				function);
	}

	public void setFunction(SimpleFunction function) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.function,
				this.function, this.function = function);
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.parameters,
				parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.parameters,
				this.parameters, this.parameters = parameters);
	}

	private Term term;

	public Term getTerm() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.term, term);
	}

	public void setTerm(Term term) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.term, this.term,
				this.term = term);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFunction().wGetAdaptee(false);
		case 1:
			return getParameters().wGetAdaptee(false);
		case 2:
			return getTerm().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFunction(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.SimpleFunction));
			break;
		case 1:
			setParameters(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters));
			break;
		case 2:
			setTerm(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Term));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
