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
public class VariableDeclarationAdapter extends AbstractEntityAdapter implements
		VariableDeclaration {
	private static final long serialVersionUID = 1;

	public VariableDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.VariableDeclaration;
	}

	public Name getName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.name).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public Name getSort() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.sort).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setSort(Name sort) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.sort, sort);
	}
}
