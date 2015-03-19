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
public class ViewComponentImpl extends AbstractSimpleEntity implements
		ViewComponent {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ViewComponent> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ViewComponent;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.ViewComponent_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private ViewDeclarations declarations;

	public ViewDeclarations getDeclarations() {
		return notifyRequested(EditorsFeatureDescriptorEnum.declarations,
				declarations);
	}

	public void setDeclarations(ViewDeclarations declarations) {
		notifyChanged(EditorsFeatureDescriptorEnum.declarations,
				this.declarations, this.declarations = declarations);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDeclarations().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDeclarations(value
					.wGetAdapter(EditorsEntityDescriptorEnum.ViewDeclarations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
