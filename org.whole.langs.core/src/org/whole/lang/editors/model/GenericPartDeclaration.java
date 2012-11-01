package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface GenericPartDeclaration extends IEditorsEntity,
		ControllerDeclaration {
	public GenericPartName getPartName();

	public void setPartName(GenericPartName partName);

	public EntityNames getEntityNames();

	public void setEntityNames(EntityNames entityNames);
}
