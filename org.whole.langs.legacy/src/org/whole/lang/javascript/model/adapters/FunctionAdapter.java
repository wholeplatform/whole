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
public class FunctionAdapter extends AbstractEntityAdapter implements Function {
	private static final long serialVersionUID = 1;

	public FunctionAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Function> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Function;
	}

	public Identifier getId() {
		return wGet(JavaScriptFeatureDescriptorEnum.id).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Identifier);
	}

	public void setId(Identifier id) {
		wSet(JavaScriptFeatureDescriptorEnum.id, id);
	}

	public Expressions getParams() {
		return wGet(JavaScriptFeatureDescriptorEnum.params).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void setParams(Expressions params) {
		wSet(JavaScriptFeatureDescriptorEnum.params, params);
	}

	public FunctionBody getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.FunctionBody);
	}

	public void setBody(FunctionBody body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
