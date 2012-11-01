package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface DeclaredContent extends IXsdEntity, ComplexTypeContent {
	public ModelGroup getModelGroup();

	public void setModelGroup(ModelGroup modelGroup);

	public AttributeUseOrGroups getAttributeUses();

	public void setAttributeUses(AttributeUseOrGroups attributeUses);

	public AnyAttribute getAnyAttribute();

	public void setAnyAttribute(AnyAttribute anyAttribute);
}
