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
public class TypeSystemImpl extends AbstractSimpleEntity implements TypeSystem {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeSystem> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.TypeSystem;
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.TypeSystem_ord;
	}

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	private Operations checkBefore;

	public Operations getCheckBefore() {
		return notifyRequested(TypesFeatureDescriptorEnum.checkBefore,
				checkBefore);
	}

	public void setCheckBefore(Operations checkBefore) {
		notifyChanged(TypesFeatureDescriptorEnum.checkBefore, this.checkBefore,
				this.checkBefore = checkBefore);
	}

	private TypeRules rules;

	public TypeRules getRules() {
		return notifyRequested(TypesFeatureDescriptorEnum.rules, rules);
	}

	public void setRules(TypeRules rules) {
		notifyChanged(TypesFeatureDescriptorEnum.rules, this.rules,
				this.rules = rules);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCheckBefore().wGetAdaptee(false);
		case 1:
			return getRules().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCheckBefore(value
					.wGetAdapter(TypesEntityDescriptorEnum.Operations));
			break;
		case 1:
			setRules(value.wGetAdapter(TypesEntityDescriptorEnum.TypeRules));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
