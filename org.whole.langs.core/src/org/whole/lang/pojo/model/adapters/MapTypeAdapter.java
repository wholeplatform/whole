package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class MapTypeAdapter extends AbstractEntityAdapter implements MapType {
	private static final long serialVersionUID = 1;

	public MapTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public MapTypeAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MapType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.MapType;
	}

	public Type getKeyType() {
		return wGet(PojoFeatureDescriptorEnum.keyType).wGetAdapter(
				PojoEntityDescriptorEnum.Type);
	}

	public void setKeyType(Type keyType) {
		wSet(PojoFeatureDescriptorEnum.keyType, keyType);
	}

	public Type getValueType() {
		return wGet(PojoFeatureDescriptorEnum.valueType).wGetAdapter(
				PojoEntityDescriptorEnum.Type);
	}

	public void setValueType(Type valueType) {
		wSet(PojoFeatureDescriptorEnum.valueType, valueType);
	}
}
