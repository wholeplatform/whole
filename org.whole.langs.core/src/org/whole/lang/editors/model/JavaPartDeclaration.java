package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface JavaPartDeclaration extends IEditorsEntity,
		ControllerDeclaration {
	public PartName getPartName();

	public void setPartName(PartName partName);

	public EntityNames getEntityNames();

	public void setEntityNames(EntityNames entityNames);
}
