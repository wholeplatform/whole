package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class StatementsAdapter extends AbstractListEntityAdapter<Statement>
		implements Statements {
	private static final long serialVersionUID = 1;

	public StatementsAdapter(IEntity implementor) {
		super(implementor);
	}

	public StatementsAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Statements> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Statements;
	}
}
