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
public class VariableInitializerImpl extends AbstractSimpleEntity implements
		VariableInitializer {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableInitializer> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.VariableInitializer;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.VariableInitializer_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression id;

	public Expression getId() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.id, id);
	}

	public void setId(Expression id) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.id, this.id, this.id = id);
	}

	private Expression init;

	public Expression getInit() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.init, init);
	}

	public void setInit(Expression init) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.init, this.init,
				this.init = init);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getId().wGetAdaptee(false);
		case 1:
			return getInit().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setId(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setInit(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
