package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypeAliasOfImpl extends AbstractSimpleEntity implements
		TypeAliasOf {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeAliasOf> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.TypeAliasOf;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.TypeAliasOf_ord;
	}

	public void accept(IModelsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Type type;

	public Type getType() {
		return notifyRequested(ModelsFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(ModelsFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private EntityType foreignType;

	public EntityType getForeignType() {
		return notifyRequested(ModelsFeatureDescriptorEnum.foreignType,
				foreignType);
	}

	public void setForeignType(EntityType foreignType) {
		notifyChanged(ModelsFeatureDescriptorEnum.foreignType,
				this.foreignType, this.foreignType = foreignType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getForeignType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(ModelsEntityDescriptorEnum.Type));
			break;
		case 1:
			setForeignType(value
					.wGetAdapter(ModelsEntityDescriptorEnum.EntityType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
