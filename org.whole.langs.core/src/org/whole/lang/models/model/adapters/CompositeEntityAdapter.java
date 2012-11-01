package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class CompositeEntityAdapter extends AbstractEntityAdapter implements
		CompositeEntity {
	private static final long serialVersionUID = 1;

	public CompositeEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public CompositeEntityAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CompositeEntity> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.CompositeEntity;
	}

	public EntityModifiers getModifiers() {
		return wGet(ModelsFeatureDescriptorEnum.modifiers).wGetAdapter(
				ModelsEntityDescriptorEnum.EntityModifiers);
	}

	public void setModifiers(EntityModifiers modifiers) {
		wSet(ModelsFeatureDescriptorEnum.modifiers, modifiers);
	}

	public SimpleName getName() {
		return wGet(ModelsFeatureDescriptorEnum.name).wGetAdapter(
				ModelsEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(ModelsFeatureDescriptorEnum.name, name);
	}

	public Types getTypes() {
		return wGet(ModelsFeatureDescriptorEnum.types).wGetAdapter(
				ModelsEntityDescriptorEnum.Types);
	}

	public void setTypes(Types types) {
		wSet(ModelsFeatureDescriptorEnum.types, types);
	}

	public ComponentModifiers getComponentModifiers() {
		return wGet(ModelsFeatureDescriptorEnum.componentModifiers)
				.wGetAdapter(ModelsEntityDescriptorEnum.ComponentModifiers);
	}

	public void setComponentModifiers(ComponentModifiers componentModifiers) {
		wSet(ModelsFeatureDescriptorEnum.componentModifiers, componentModifiers);
	}

	public Type getComponentType() {
		return wGet(ModelsFeatureDescriptorEnum.componentType).wGetAdapter(
				ModelsEntityDescriptorEnum.Type);
	}

	public void setComponentType(Type componentType) {
		wSet(ModelsFeatureDescriptorEnum.componentType, componentType);
	}
}
