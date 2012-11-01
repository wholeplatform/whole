package org.whole.lang.commons.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.commons.model.*;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MultiplexerStrictImpl extends AbstractBagCompositeEntity<Any>
		implements Multiplexer {
	private static final long serialVersionUID = 1;

	public void accept(ICommonsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.Multiplexer_ord;
	}

	public EntityDescriptor<Multiplexer> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Multiplexer;
	}
}
