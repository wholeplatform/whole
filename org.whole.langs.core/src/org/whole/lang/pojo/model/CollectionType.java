package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface CollectionType extends IPojoEntity, Type {
	public CollectionInterface getCollectionInterface();

	public void setCollectionInterface(CollectionInterface collectionInterface);

	public Type getElementType();

	public void setElementType(Type elementType);
}
