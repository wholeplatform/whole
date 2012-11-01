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
public class FeatureAdapter extends AbstractEntityAdapter implements Feature {
	private static final long serialVersionUID = 1;

	public FeatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Feature> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Feature;
	}

	public FeatureModifiers getModifiers() {
		return wGet(ModelsFeatureDescriptorEnum.modifiers).wGetAdapter(
				ModelsEntityDescriptorEnum.FeatureModifiers);
	}

	public void setModifiers(FeatureModifiers modifiers) {
		wSet(ModelsFeatureDescriptorEnum.modifiers, modifiers);
	}

	public Type getType() {
		return wGet(ModelsFeatureDescriptorEnum.type).wGetAdapter(
				ModelsEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(ModelsFeatureDescriptorEnum.type, type);
	}

	public SimpleName getName() {
		return wGet(ModelsFeatureDescriptorEnum.name).wGetAdapter(
				ModelsEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(ModelsFeatureDescriptorEnum.name, name);
	}

	public SimpleName getOppositeName() {
		return wGet(ModelsFeatureDescriptorEnum.oppositeName).wGetAdapter(
				ModelsEntityDescriptorEnum.SimpleName);
	}

	public void setOppositeName(SimpleName oppositeName) {
		wSet(ModelsFeatureDescriptorEnum.oppositeName, oppositeName);
	}
}
