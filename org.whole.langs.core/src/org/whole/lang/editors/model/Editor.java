package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface Editor extends IEditorsEntity {
	public EditorName getEditorName();

	public void setEditorName(EditorName editorName);

	public EditorName getSuperEditorName();

	public void setSuperEditorName(EditorName superEditorName);

	public ModelComponent getModelComponent();

	public void setModelComponent(ModelComponent modelComponent);

	public ViewComponent getViewComponent();

	public void setViewComponent(ViewComponent viewComponent);

	public ControllerComponent getControllerComponent();

	public void setControllerComponent(ControllerComponent controllerComponent);
}
