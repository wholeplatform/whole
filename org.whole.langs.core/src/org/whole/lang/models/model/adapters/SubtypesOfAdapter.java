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
public class SubtypesOfAdapter extends AbstractEntityAdapter implements
		SubtypesOf {
	private static final long serialVersionUID = 1;

	public SubtypesOfAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubtypesOfAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SubtypesOf> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.SubtypesOf;
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
