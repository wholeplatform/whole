package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BlockStatementAdapter extends AbstractListEntityAdapter<Statement> implements BlockStatement {
	private static final long serialVersionUID = 1;

	public BlockStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public BlockStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BlockStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.BlockStatement;
	}
}
