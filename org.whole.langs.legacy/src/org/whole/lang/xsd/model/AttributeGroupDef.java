package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface AttributeGroupDef extends IXsdEntity, NamedComponent,
		Annotated, SchemaComponent, RedefineComponent {
	public AttributeUseOrGroups getAttributeUses();

	public void setAttributeUses(AttributeUseOrGroups attributeUses);

	public AnyAttribute getAnyAttribute();

	public void setAnyAttribute(AnyAttribute anyAttribute);
}
