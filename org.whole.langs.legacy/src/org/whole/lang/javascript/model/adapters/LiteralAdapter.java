package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class LiteralAdapter extends AbstractEntityAdapter implements Literal {
	private static final long serialVersionUID = 1;

	public LiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public LiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Literal> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Literal;
	}
}
