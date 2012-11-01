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
public class ModelComponentAdapter extends AbstractEntityAdapter implements
		ModelComponent {
	private static final long serialVersionUID = 1;

	public ModelComponentAdapter(IEntity implementor) {
		super(implementor);
	}

	public ModelComponentAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ModelComponent> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ModelComponent;
	}

	public ModelName getModelName() {
		return wGet(EditorsFeatureDescriptorEnum.modelName).wGetAdapter(
				EditorsEntityDescriptorEnum.ModelName);
	}

	public void setModelName(ModelName modelName) {
		wSet(EditorsFeatureDescriptorEnum.modelName, modelName);
	}
}
