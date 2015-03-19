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
public class SimpleEntityImpl extends AbstractSimpleEntity implements
		SimpleEntity {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SimpleEntity> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.SimpleEntity;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.SimpleEntity_ord;
	}

	public void accept(IModelsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private Features features;

	public Features getFeatures() {
		return notifyRequested(ModelsFeatureDescriptorEnum.features, features);
	}

	public void setFeatures(Features features) {
		notifyChanged(ModelsFeatureDescriptorEnum.features, this.features,
				this.features = features);
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
			return getFeatures().wGetAdaptee(false);
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
			setFeatures(value.wGetAdapter(ModelsEntityDescriptorEnum.Features));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
