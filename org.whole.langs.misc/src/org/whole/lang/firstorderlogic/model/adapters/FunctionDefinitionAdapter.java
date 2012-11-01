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
public class FunctionDefinitionAdapter extends AbstractEntityAdapter implements
		FunctionDefinition {
	private static final long serialVersionUID = 1;

	public FunctionDefinitionAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionDefinitionAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionDefinition> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionDefinition;
	}

	public SimpleFunction getFunction() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.function).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.SimpleFunction);
	}

	public void setFunction(SimpleFunction function) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.function, function);
	}

	public Parameters getParameters() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.parameters)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.parameters, parameters);
	}

	public Term getTerm() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.term).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Term);
	}

	public void setTerm(Term term) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.term, term);
	}
}
