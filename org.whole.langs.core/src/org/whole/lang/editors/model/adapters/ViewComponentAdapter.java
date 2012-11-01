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
public class ViewComponentAdapter extends AbstractEntityAdapter implements
		ViewComponent {
	private static final long serialVersionUID = 1;

	public ViewComponentAdapter(IEntity implementor) {
		super(implementor);
	}

	public ViewComponentAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ViewComponent> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ViewComponent;
	}

	public ViewDeclarations getDeclarations() {
		return wGet(EditorsFeatureDescriptorEnum.declarations).wGetAdapter(
				EditorsEntityDescriptorEnum.ViewDeclarations);
	}

	public void setDeclarations(ViewDeclarations declarations) {
		wSet(EditorsFeatureDescriptorEnum.declarations, declarations);
	}
}
