package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;

/** 
 * @generator Whole
 */
public class SpaceImpl extends AbstractSimpleEntity implements Space {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Space> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Space;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Space_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
