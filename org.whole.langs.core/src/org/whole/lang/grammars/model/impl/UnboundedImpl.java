package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;

/** 
 * @generator Whole
 */
public class UnboundedImpl extends AbstractSimpleEntity implements Unbounded {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Unbounded> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Unbounded;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Unbounded_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
