package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ArgumentsImpl extends AbstractListCompositeEntity<Term> implements
		Arguments {
	private static final long serialVersionUID = 1;

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.Arguments_ord;
	}

	public EntityDescriptor<Arguments> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Arguments;
	}
}
