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
public class SimpleEntityAdapter extends AbstractEntityAdapter implements
		SimpleEntity {
	private static final long serialVersionUID = 1;

	public SimpleEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleEntityAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleEntity> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.SimpleEntity;
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

	public Features getFeatures() {
		return wGet(ModelsFeatureDescriptorEnum.features).wGetAdapter(
				ModelsEntityDescriptorEnum.Features);
	}

	public void setFeatures(Features features) {
		wSet(ModelsFeatureDescriptorEnum.features, features);
	}
}
