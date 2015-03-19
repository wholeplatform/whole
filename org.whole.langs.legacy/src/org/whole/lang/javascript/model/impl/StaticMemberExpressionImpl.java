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
public class StaticMemberExpressionImpl extends AbstractSimpleEntity implements
		StaticMemberExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<StaticMemberExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.StaticMemberExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.StaticMemberExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression object;

	public Expression getObject() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.object, object);
	}

	public void setObject(Expression object) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.object, this.object,
				this.object = object);
	}

	private IdentifierOrXmlAny property;

	public IdentifierOrXmlAny getProperty() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.property,
				property);
	}

	public void setProperty(IdentifierOrXmlAny property) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.property, this.property,
				this.property = property);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getObject().wGetAdaptee(false);
		case 1:
			return getProperty().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setObject(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setProperty(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
