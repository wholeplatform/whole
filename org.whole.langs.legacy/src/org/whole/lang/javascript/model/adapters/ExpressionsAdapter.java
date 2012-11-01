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
public class ExpressionsAdapter extends AbstractListEntityAdapter<Expression>
		implements Expressions {
	private static final long serialVersionUID = 1;

	public ExpressionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExpressionsAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Expressions> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Expressions;
	}
}
