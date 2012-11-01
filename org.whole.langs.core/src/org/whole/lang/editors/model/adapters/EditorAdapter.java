package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class EditorAdapter extends AbstractEntityAdapter implements Editor {
	private static final long serialVersionUID = 1;

	public EditorAdapter(IEntity implementor) {
		super(implementor);
	}

	public EditorAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Editor> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.Editor;
	}

	public EditorName getEditorName() {
		return wGet(EditorsFeatureDescriptorEnum.editorName).wGetAdapter(
				EditorsEntityDescriptorEnum.EditorName);
	}

	public void setEditorName(EditorName editorName) {
		wSet(EditorsFeatureDescriptorEnum.editorName, editorName);
	}

	public EditorName getSuperEditorName() {
		return wGet(EditorsFeatureDescriptorEnum.superEditorName).wGetAdapter(
				EditorsEntityDescriptorEnum.EditorName);
	}

	public void setSuperEditorName(EditorName superEditorName) {
		wSet(EditorsFeatureDescriptorEnum.superEditorName, superEditorName);
	}

	public ModelComponent getModelComponent() {
		return wGet(EditorsFeatureDescriptorEnum.modelComponent).wGetAdapter(
				EditorsEntityDescriptorEnum.ModelComponent);
	}

	public void setModelComponent(ModelComponent modelComponent) {
		wSet(EditorsFeatureDescriptorEnum.modelComponent, modelComponent);
	}

	public ViewComponent getViewComponent() {
		return wGet(EditorsFeatureDescriptorEnum.viewComponent).wGetAdapter(
				EditorsEntityDescriptorEnum.ViewComponent);
	}

	public void setViewComponent(ViewComponent viewComponent) {
		wSet(EditorsFeatureDescriptorEnum.viewComponent, viewComponent);
	}

	public ControllerComponent getControllerComponent() {
		return wGet(EditorsFeatureDescriptorEnum.controllerComponent)
				.wGetAdapter(EditorsEntityDescriptorEnum.ControllerComponent);
	}

	public void setControllerComponent(ControllerComponent controllerComponent) {
		wSet(EditorsFeatureDescriptorEnum.controllerComponent,
				controllerComponent);
	}
}
