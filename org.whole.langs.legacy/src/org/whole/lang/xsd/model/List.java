package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface List extends IXsdEntity, SimpleTypeContent {
	public QName getItemType();

	public void setItemType(QName itemType);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public SimpleTypeDef getItemTypeDef();

	public void setItemTypeDef(SimpleTypeDef itemTypeDef);
}
