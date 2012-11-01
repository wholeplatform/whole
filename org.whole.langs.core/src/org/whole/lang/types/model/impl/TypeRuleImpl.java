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
public class TypeRuleImpl extends AbstractSimpleEntity implements TypeRule {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeRule> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.TypeRule;
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.TypeRule_ord;
	}

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	private DomainType domain;

	public DomainType getDomain() {
		return notifyRequested(TypesFeatureDescriptorEnum.domain, domain);
	}

	public void setDomain(DomainType domain) {
		notifyChanged(TypesFeatureDescriptorEnum.domain, this.domain,
				this.domain = domain);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(TypesFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(TypesFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDomain().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDomain(value.wGetAdapter(TypesEntityDescriptorEnum.DomainType));
			break;
		case 1:
			setType(value.wGetAdapter(TypesEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
