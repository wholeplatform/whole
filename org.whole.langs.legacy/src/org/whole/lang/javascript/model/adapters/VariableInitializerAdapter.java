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
public class VariableInitializerAdapter extends AbstractEntityAdapter implements
		VariableInitializer {
	private static final long serialVersionUID = 1;

	public VariableInitializerAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableInitializerAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableInitializer> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.VariableInitializer;
	}

	public Expression getId() {
		return wGet(JavaScriptFeatureDescriptorEnum.id).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setId(Expression id) {
		wSet(JavaScriptFeatureDescriptorEnum.id, id);
	}

	public Expression getInit() {
		return wGet(JavaScriptFeatureDescriptorEnum.init).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setInit(Expression init) {
		wSet(JavaScriptFeatureDescriptorEnum.init, init);
	}
}
