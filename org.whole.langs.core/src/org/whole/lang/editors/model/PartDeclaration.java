package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface PartDeclaration extends IEditorsEntity, ControllerDeclaration {
	public PartName getPartName();

	public void setPartName(PartName partName);

	public EntityName getEntityName();

	public void setEntityName(EntityName entityName);

	public FigureName getFigureName();

	public void setFigureName(FigureName figureName);

	public EntityFeatures getEntityFeatures();

	public void setEntityFeatures(EntityFeatures entityFeatures);
}
