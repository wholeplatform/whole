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
public class SubtypeDeclarationAdapter extends AbstractEntityAdapter implements
		SubtypeDeclaration {
	private static final long serialVersionUID = 1;

	public SubtypeDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubtypeDeclarationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SubtypeDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration;
	}

	public Name getSubSort() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.subSort).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setSubSort(Name subSort) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.subSort, subSort);
	}

	public Name getSuperSort() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.superSort)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setSuperSort(Name superSort) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.superSort, superSort);
	}
}
