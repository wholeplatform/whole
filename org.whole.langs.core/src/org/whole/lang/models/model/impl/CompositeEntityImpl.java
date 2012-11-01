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
public class CompositeEntityImpl extends AbstractSimpleEntity implements
		CompositeEntity {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CompositeEntity> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.CompositeEntity;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.CompositeEntity_ord;
	}

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}

	private EntityModifiers modifiers;

	public EntityModifiers getModifiers() {
		return notifyRequested(ModelsFeatureDescriptorEnum.modifiers, modifiers);
	}

	public void setModifiers(EntityModifiers modifiers) {
		notifyChanged(ModelsFeatureDescriptorEnum.modifiers, this.modifiers,
				this.modifiers = modifiers);
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(ModelsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(ModelsFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(ModelsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Types types;

	public Types getTypes() {
		return notifyRequested(ModelsFeatureDescriptorEnum.types, types);
	}

	public void setTypes(Types types) {
		notifyChanged(ModelsFeatureDescriptorEnum.types, this.types,
				this.types = types);
	}

	private ComponentModifiers componentModifiers;

	public ComponentModifiers getComponentModifiers() {
		return notifyRequested(ModelsFeatureDescriptorEnum.componentModifiers,
				componentModifiers);
	}

	public void setComponentModifiers(ComponentModifiers componentModifiers) {
		notifyChanged(ModelsFeatureDescriptorEnum.componentModifiers,
				this.componentModifiers,
				this.componentModifiers = componentModifiers);
	}

	private Type componentType;

	public Type getComponentType() {
		return notifyRequested(ModelsFeatureDescriptorEnum.componentType,
				componentType);
	}

	public void setComponentType(Type componentType) {
		notifyChanged(ModelsFeatureDescriptorEnum.componentType,
				this.componentType, this.componentType = componentType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getModifiers().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getTypes().wGetAdaptee(false);
		case 3:
			return getComponentModifiers().wGetAdaptee(false);
		case 4:
			return getComponentType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setModifiers(value
					.wGetAdapter(ModelsEntityDescriptorEnum.EntityModifiers));
			break;
		case 1:
			setName(value.wGetAdapter(ModelsEntityDescriptorEnum.SimpleName));
			break;
		case 2:
			setTypes(value.wGetAdapter(ModelsEntityDescriptorEnum.Types));
			break;
		case 3:
			setComponentModifiers(value
					.wGetAdapter(ModelsEntityDescriptorEnum.ComponentModifiers));
			break;
		case 4:
			setComponentType(value.wGetAdapter(ModelsEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
