package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ModelGroupDef extends IXsdEntity, NamedComponent, Annotated,
		SchemaComponent, RedefineComponent {
	public ModelGroup getModelGroup();

	public void setModelGroup(ModelGroup modelGroup);
}
