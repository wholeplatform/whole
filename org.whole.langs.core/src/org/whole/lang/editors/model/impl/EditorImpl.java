package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EditorImpl extends AbstractSimpleEntity implements Editor {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Editor> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.Editor;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.Editor_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private EditorName editorName;

	public EditorName getEditorName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.editorName,
				editorName);
	}

	public void setEditorName(EditorName editorName) {
		notifyChanged(EditorsFeatureDescriptorEnum.editorName, this.editorName,
				this.editorName = editorName);
	}

	private EditorName superEditorName;

	public EditorName getSuperEditorName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.superEditorName,
				superEditorName);
	}

	public void setSuperEditorName(EditorName superEditorName) {
		notifyChanged(EditorsFeatureDescriptorEnum.superEditorName,
				this.superEditorName, this.superEditorName = superEditorName);
	}

	private ModelComponent modelComponent;

	public ModelComponent getModelComponent() {
		return notifyRequested(EditorsFeatureDescriptorEnum.modelComponent,
				modelComponent);
	}

	public void setModelComponent(ModelComponent modelComponent) {
		notifyChanged(EditorsFeatureDescriptorEnum.modelComponent,
				this.modelComponent, this.modelComponent = modelComponent);
	}

	private ViewComponent viewComponent;

	public ViewComponent getViewComponent() {
		return notifyRequested(EditorsFeatureDescriptorEnum.viewComponent,
				viewComponent);
	}

	public void setViewComponent(ViewComponent viewComponent) {
		notifyChanged(EditorsFeatureDescriptorEnum.viewComponent,
				this.viewComponent, this.viewComponent = viewComponent);
	}

	private ControllerComponent controllerComponent;

	public ControllerComponent getControllerComponent() {
		return notifyRequested(
				EditorsFeatureDescriptorEnum.controllerComponent,
				controllerComponent);
	}

	public void setControllerComponent(ControllerComponent controllerComponent) {
		notifyChanged(EditorsFeatureDescriptorEnum.controllerComponent,
				this.controllerComponent,
				this.controllerComponent = controllerComponent);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getEditorName().wGetAdaptee(false);
		case 1:
			return getSuperEditorName().wGetAdaptee(false);
		case 2:
			return getModelComponent().wGetAdaptee(false);
		case 3:
			return getViewComponent().wGetAdaptee(false);
		case 4:
			return getControllerComponent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setEditorName(value
					.wGetAdapter(EditorsEntityDescriptorEnum.EditorName));
			break;
		case 1:
			setSuperEditorName(value
					.wGetAdapter(EditorsEntityDescriptorEnum.EditorName));
			break;
		case 2:
			setModelComponent(value
					.wGetAdapter(EditorsEntityDescriptorEnum.ModelComponent));
			break;
		case 3:
			setViewComponent(value
					.wGetAdapter(EditorsEntityDescriptorEnum.ViewComponent));
			break;
		case 4:
			setControllerComponent(value
					.wGetAdapter(EditorsEntityDescriptorEnum.ControllerComponent));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
