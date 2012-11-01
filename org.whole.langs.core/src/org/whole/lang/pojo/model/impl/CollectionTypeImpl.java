package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CollectionTypeImpl extends AbstractSimpleEntity implements
		CollectionType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CollectionType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.CollectionType;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.CollectionType_ord;
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	private CollectionInterface collectionInterface;

	public CollectionInterface getCollectionInterface() {
		return notifyRequested(PojoFeatureDescriptorEnum.collectionInterface,
				collectionInterface);
	}

	public void setCollectionInterface(CollectionInterface collectionInterface) {
		notifyChanged(PojoFeatureDescriptorEnum.collectionInterface,
				this.collectionInterface,
				this.collectionInterface = collectionInterface);
	}

	private Type elementType;

	public Type getElementType() {
		return notifyRequested(PojoFeatureDescriptorEnum.elementType,
				elementType);
	}

	public void setElementType(Type elementType) {
		notifyChanged(PojoFeatureDescriptorEnum.elementType, this.elementType,
				this.elementType = elementType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCollectionInterface().wGetAdaptee(false);
		case 1:
			return getElementType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCollectionInterface(value
					.wGetAdapter(PojoEntityDescriptorEnum.CollectionInterface));
			break;
		case 1:
			setElementType(value.wGetAdapter(PojoEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
