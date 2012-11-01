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
public class VariableInitializersAdapter extends
		AbstractListEntityAdapter<VariableInitializer> implements
		VariableInitializers {
	private static final long serialVersionUID = 1;

	public VariableInitializersAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableInitializersAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableInitializers> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.VariableInitializers;
	}
}
