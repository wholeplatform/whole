package org.whole.lang.commons.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.commons.model.*;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MultiplexerImpl extends AbstractCollectionCompositeEntity<Any>
		implements Multiplexer {
	private static final long serialVersionUID = 1;

	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.Multiplexer_ord;
	}

	public EntityDescriptor<Multiplexer> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Multiplexer;
	}
}
