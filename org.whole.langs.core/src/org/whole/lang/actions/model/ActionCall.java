package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface ActionCall extends IActionsEntity, Transformation {
	public Label getName();

	public void setName(Label name);

	public SelectedEntities getSelectedEntities();

	public void setSelectedEntities(SelectedEntities selectedEntities);
}
