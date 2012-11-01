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
public class CollectionTypeAdapter extends AbstractEntityAdapter implements
		CollectionType {
	private static final long serialVersionUID = 1;

	public CollectionTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public CollectionTypeAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CollectionType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.CollectionType;
	}

	public CollectionInterface getCollectionInterface() {
		return wGet(PojoFeatureDescriptorEnum.collectionInterface).wGetAdapter(
				PojoEntityDescriptorEnum.CollectionInterface);
	}

	public void setCollectionInterface(CollectionInterface collectionInterface) {
		wSet(PojoFeatureDescriptorEnum.collectionInterface, collectionInterface);
	}

	public Type getElementType() {
		return wGet(PojoFeatureDescriptorEnum.elementType).wGetAdapter(
				PojoEntityDescriptorEnum.Type);
	}

	public void setElementType(Type elementType) {
		wSet(PojoFeatureDescriptorEnum.elementType, elementType);
	}
}
