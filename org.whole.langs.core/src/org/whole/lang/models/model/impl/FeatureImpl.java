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
public class FeatureImpl extends AbstractSimpleEntity implements Feature {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Feature> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Feature;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.Feature_ord;
	}

	public void accept(IModelsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private FeatureModifiers modifiers;

	public FeatureModifiers getModifiers() {
		return notifyRequested(ModelsFeatureDescriptorEnum.modifiers, modifiers);
	}

	public void setModifiers(FeatureModifiers modifiers) {
		notifyChanged(ModelsFeatureDescriptorEnum.modifiers, this.modifiers,
				this.modifiers = modifiers);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(ModelsFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(ModelsFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(ModelsFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(ModelsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private SimpleName oppositeName;

	public SimpleName getOppositeName() {
		return notifyRequested(ModelsFeatureDescriptorEnum.oppositeName,
				oppositeName);
	}

	public void setOppositeName(SimpleName oppositeName) {
		notifyChanged(ModelsFeatureDescriptorEnum.oppositeName,
				this.oppositeName, this.oppositeName = oppositeName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getModifiers().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getOppositeName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setModifiers(value
					.wGetAdapter(ModelsEntityDescriptorEnum.FeatureModifiers));
			break;
		case 1:
			setType(value.wGetAdapter(ModelsEntityDescriptorEnum.Type));
			break;
		case 2:
			setName(value.wGetAdapter(ModelsEntityDescriptorEnum.SimpleName));
			break;
		case 3:
			setOppositeName(value
					.wGetAdapter(ModelsEntityDescriptorEnum.SimpleName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
