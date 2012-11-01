package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SupertypeImpl extends AbstractSimpleEntity implements Supertype {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Supertype> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Supertype;
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.Supertype_ord;
	}

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	private VariableType name;

	public VariableType getName() {
		return notifyRequested(TypesFeatureDescriptorEnum.name, name);
	}

	public void setName(VariableType name) {
		notifyChanged(TypesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private VariableType type;

	public VariableType getType() {
		return notifyRequested(TypesFeatureDescriptorEnum.type, type);
	}

	public void setType(VariableType type) {
		notifyChanged(TypesFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(TypesEntityDescriptorEnum.VariableType));
			break;
		case 1:
			setType(value.wGetAdapter(TypesEntityDescriptorEnum.VariableType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
