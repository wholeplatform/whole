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
public class SupertypeAdapter extends AbstractEntityAdapter implements
		Supertype {
	private static final long serialVersionUID = 1;

	public SupertypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public SupertypeAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Supertype> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Supertype;
	}

	public VariableType getName() {
		return wGet(TypesFeatureDescriptorEnum.name).wGetAdapter(
				TypesEntityDescriptorEnum.VariableType);
	}

	public void setName(VariableType name) {
		wSet(TypesFeatureDescriptorEnum.name, name);
	}

	public VariableType getType() {
		return wGet(TypesFeatureDescriptorEnum.type).wGetAdapter(
				TypesEntityDescriptorEnum.VariableType);
	}

	public void setType(VariableType type) {
		wSet(TypesFeatureDescriptorEnum.type, type);
	}
}
