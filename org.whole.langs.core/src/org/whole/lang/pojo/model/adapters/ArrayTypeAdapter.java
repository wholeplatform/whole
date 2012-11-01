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
public class ArrayTypeAdapter extends AbstractEntityAdapter implements
		ArrayType {
	private static final long serialVersionUID = 1;

	public ArrayTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayTypeAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.ArrayType;
	}

	public Type getElementType() {
		return wGet(PojoFeatureDescriptorEnum.elementType).wGetAdapter(
				PojoEntityDescriptorEnum.Type);
	}

	public void setElementType(Type elementType) {
		wSet(PojoFeatureDescriptorEnum.elementType, elementType);
	}
}
