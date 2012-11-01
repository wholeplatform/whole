package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FunctionDeclarationImpl extends AbstractSimpleEntity implements
		FunctionDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionDeclaration> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.FunctionDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.FunctionDeclaration_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Identifier id;

	public Identifier getId() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.id, id);
	}

	public void setId(Identifier id) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.id, this.id, this.id = id);
	}

	private Expressions params;

	public Expressions getParams() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.params, params);
	}

	public void setParams(Expressions params) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.params, this.params,
				this.params = params);
	}

	private FunctionBody body;

	public FunctionBody getBody() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.body, body);
	}

	public void setBody(FunctionBody body) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getId().wGetAdaptee(false);
		case 1:
			return getParams().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setId(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Identifier));
			break;
		case 1:
			setParams(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expressions));
			break;
		case 2:
			setBody(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.FunctionBody));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
