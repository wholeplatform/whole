package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface SimpleExtension extends IXsdEntity, SimpleDerivation {
	public QName getBase();

	public void setBase(QName base);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public AttributeUseOrGroups getAttributeUses();

	public void setAttributeUses(AttributeUseOrGroups attributeUses);

	public AnyAttribute getAnyAttribute();

	public void setAnyAttribute(AnyAttribute anyAttribute);
}
