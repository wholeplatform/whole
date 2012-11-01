package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypeSystemAdapter extends AbstractEntityAdapter implements
		TypeSystem {
	private static final long serialVersionUID = 1;

	public TypeSystemAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeSystemAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeSystem> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.TypeSystem;
	}

	public Operations getCheckBefore() {
		return wGet(TypesFeatureDescriptorEnum.checkBefore).wGetAdapter(
				TypesEntityDescriptorEnum.Operations);
	}

	public void setCheckBefore(Operations checkBefore) {
		wSet(TypesFeatureDescriptorEnum.checkBefore, checkBefore);
	}

	public TypeRules getRules() {
		return wGet(TypesFeatureDescriptorEnum.rules).wGetAdapter(
				TypesEntityDescriptorEnum.TypeRules);
	}

	public void setRules(TypeRules rules) {
		wSet(TypesFeatureDescriptorEnum.rules, rules);
	}
}
