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
public class FunctionTypeAdapter extends AbstractEntityAdapter implements
		FunctionType {
	private static final long serialVersionUID = 1;

	public FunctionTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionTypeAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionType> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FunctionType;
	}

	public Parameters getParameters() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.parameters)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.parameters, parameters);
	}

	public Name getSort() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.sort).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setSort(Name sort) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.sort, sort);
	}
}
