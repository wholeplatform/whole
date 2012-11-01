package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FactoryDeclarationImpl extends AbstractSimpleEntity implements
		FactoryDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FactoryDeclaration> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.FactoryDeclaration;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.FactoryDeclaration_ord;
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	private ReferenceType name;

	public ReferenceType getName() {
		return notifyRequested(PojoFeatureDescriptorEnum.name, name);
	}

	public void setName(ReferenceType name) {
		notifyChanged(PojoFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Name prefix;

	public Name getPrefix() {
		return notifyRequested(PojoFeatureDescriptorEnum.prefix, prefix);
	}

	public void setPrefix(Name prefix) {
		notifyChanged(PojoFeatureDescriptorEnum.prefix, this.prefix,
				this.prefix = prefix);
	}

	private FactoryMethods factoryMethods;

	public FactoryMethods getFactoryMethods() {
		return notifyRequested(PojoFeatureDescriptorEnum.factoryMethods,
				factoryMethods);
	}

	public void setFactoryMethods(FactoryMethods factoryMethods) {
		notifyChanged(PojoFeatureDescriptorEnum.factoryMethods,
				this.factoryMethods, this.factoryMethods = factoryMethods);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getPrefix().wGetAdaptee(false);
		case 2:
			return getFactoryMethods().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(PojoEntityDescriptorEnum.ReferenceType));
			break;
		case 1:
			setPrefix(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		case 2:
			setFactoryMethods(value
					.wGetAdapter(PojoEntityDescriptorEnum.FactoryMethods));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
