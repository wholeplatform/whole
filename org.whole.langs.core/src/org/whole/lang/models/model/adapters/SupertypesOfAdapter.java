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
public class SupertypesOfAdapter extends AbstractEntityAdapter implements
		SupertypesOf {
	private static final long serialVersionUID = 1;

	public SupertypesOfAdapter(IEntity implementor) {
		super(implementor);
	}

	public SupertypesOfAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SupertypesOf> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.SupertypesOf;
	}

	public Types getTypes() {
		return wGet(ModelsFeatureDescriptorEnum.types).wGetAdapter(
				ModelsEntityDescriptorEnum.Types);
	}

	public void setTypes(Types types) {
		wSet(ModelsFeatureDescriptorEnum.types, types);
	}

	public ForeignType getForeignType() {
		return wGet(ModelsFeatureDescriptorEnum.foreignType).wGetAdapter(
				ModelsEntityDescriptorEnum.ForeignType);
	}

	public void setForeignType(ForeignType foreignType) {
		wSet(ModelsFeatureDescriptorEnum.foreignType, foreignType);
	}
}
