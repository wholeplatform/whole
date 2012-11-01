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
public class ControllerComponentAdapter extends AbstractEntityAdapter implements
		ControllerComponent {
	private static final long serialVersionUID = 1;

	public ControllerComponentAdapter(IEntity implementor) {
		super(implementor);
	}

	public ControllerComponentAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ControllerComponent> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ControllerComponent;
	}

	public ControllerDeclarations getDeclarations() {
		return wGet(EditorsFeatureDescriptorEnum.declarations).wGetAdapter(
				EditorsEntityDescriptorEnum.ControllerDeclarations);
	}

	public void setDeclarations(ControllerDeclarations declarations) {
		wSet(EditorsFeatureDescriptorEnum.declarations, declarations);
	}
}
