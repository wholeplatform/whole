package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ExpressionOrStatementAdapter extends AbstractEntityAdapter
		implements ExpressionOrStatement {
	private static final long serialVersionUID = 1;

	public ExpressionOrStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExpressionOrStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ExpressionOrStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ExpressionOrStatement;
	}
}
