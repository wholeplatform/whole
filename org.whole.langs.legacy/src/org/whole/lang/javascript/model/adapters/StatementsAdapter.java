package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

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

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Statements> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Statements;
	}
}
