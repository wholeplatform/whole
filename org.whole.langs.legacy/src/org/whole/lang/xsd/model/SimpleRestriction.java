package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface SimpleRestriction extends IXsdEntity, SimpleDerivation {
	public QName getBase();

	public void setBase(QName base);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public SimpleTypeDef getBaseDef();

	public void setBaseDef(SimpleTypeDef baseDef);

	public Facets getFacets();

	public void setFacets(Facets facets);

	public AttributeUseOrGroups getAttributeUses();

	public void setAttributeUses(AttributeUseOrGroups attributeUses);

	public AnyAttribute getAnyAttribute();

	public void setAnyAttribute(AnyAttribute anyAttribute);
}
