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
public class TypeAliasOfAdapter extends AbstractEntityAdapter implements
		TypeAliasOf {
	private static final long serialVersionUID = 1;

	public TypeAliasOfAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeAliasOfAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeAliasOf> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.TypeAliasOf;
	}

	public Type getType() {
		return wGet(ModelsFeatureDescriptorEnum.type).wGetAdapter(
				ModelsEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(ModelsFeatureDescriptorEnum.type, type);
	}

	public EntityType getForeignType() {
		return wGet(ModelsFeatureDescriptorEnum.foreignType).wGetAdapter(
				ModelsEntityDescriptorEnum.EntityType);
	}

	public void setForeignType(EntityType foreignType) {
		wSet(ModelsFeatureDescriptorEnum.foreignType, foreignType);
	}
}
