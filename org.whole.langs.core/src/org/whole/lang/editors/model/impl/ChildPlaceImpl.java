package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.visitors.IEditorsVisitor;

/** 
 * @generator Whole
 */
public class ChildPlaceImpl extends AbstractSimpleEntity implements ChildPlace {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ChildPlace> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ChildPlace;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.ChildPlace_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
