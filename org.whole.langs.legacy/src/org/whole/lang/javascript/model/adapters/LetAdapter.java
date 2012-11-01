package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class LetAdapter extends AbstractEntityAdapter implements Let {
	private static final long serialVersionUID = 1;

	public LetAdapter(IEntity implementor) {
		super(implementor);
	}

	public LetAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Let> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Let;
	}

	public VariableInitializers getVariables() {
		return wGet(JavaScriptFeatureDescriptorEnum.variables).wGetAdapter(
				JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public void setVariables(VariableInitializers variables) {
		wSet(JavaScriptFeatureDescriptorEnum.variables, variables);
	}
}
