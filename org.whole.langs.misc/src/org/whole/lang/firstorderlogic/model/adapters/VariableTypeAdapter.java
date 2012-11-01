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
public class VariableTypeAdapter extends AbstractEntityAdapter implements
		VariableType {
	private static final long serialVersionUID = 1;

	public VariableTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableTypeAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableType> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.VariableType;
	}

	public Name getSort() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.sort).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setSort(Name sort) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.sort, sort);
	}
}
