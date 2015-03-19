package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;

/** 
 * @generator Whole
 */
public class SortTypeImpl extends AbstractSimpleEntity implements SortType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SortType> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.SortType;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.SortType_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
