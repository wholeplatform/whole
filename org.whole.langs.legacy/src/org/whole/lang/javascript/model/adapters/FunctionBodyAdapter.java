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
public class FunctionBodyAdapter extends AbstractEntityAdapter implements
		FunctionBody {
	private static final long serialVersionUID = 1;

	public FunctionBodyAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionBodyAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionBody> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.FunctionBody;
	}
}
