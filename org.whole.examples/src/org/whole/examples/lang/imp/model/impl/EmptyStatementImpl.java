package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;

/** 
 * @generator Whole
 */
public class EmptyStatementImpl extends AbstractSimpleEntity implements
		EmptyStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EmptyStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.EmptyStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.EmptyStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		visitor.visit(this);
	}
}
