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
public class DataEntityAdapter extends AbstractEntityAdapter implements
		DataEntity {
	private static final long serialVersionUID = 1;

	public DataEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public DataEntityAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DataEntity> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.DataEntity;
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

	public DataType getDataType() {
		return wGet(ModelsFeatureDescriptorEnum.dataType).wGetAdapter(
				ModelsEntityDescriptorEnum.DataType);
	}

	public void setDataType(DataType dataType) {
		wSet(ModelsFeatureDescriptorEnum.dataType, dataType);
	}
}
