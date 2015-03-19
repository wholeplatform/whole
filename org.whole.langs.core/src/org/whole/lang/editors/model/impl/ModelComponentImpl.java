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
public class ModelComponentImpl extends AbstractSimpleEntity implements
		ModelComponent {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ModelComponent> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ModelComponent;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.ModelComponent_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private ModelName modelName;

	public ModelName getModelName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.modelName,
				modelName);
	}

	public void setModelName(ModelName modelName) {
		notifyChanged(EditorsFeatureDescriptorEnum.modelName, this.modelName,
				this.modelName = modelName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getModelName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setModelName(value
					.wGetAdapter(EditorsEntityDescriptorEnum.ModelName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
