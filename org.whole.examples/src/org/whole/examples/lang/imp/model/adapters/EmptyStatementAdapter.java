package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EmptyStatementAdapter extends AbstractEntityAdapter implements EmptyStatement {
	private static final long serialVersionUID = 1;

	public EmptyStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public EmptyStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EmptyStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.EmptyStatement;
	}
}
