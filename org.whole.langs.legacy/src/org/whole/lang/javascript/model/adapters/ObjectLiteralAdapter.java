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
public class ObjectLiteralAdapter extends AbstractEntityAdapter implements
		ObjectLiteral {
	private static final long serialVersionUID = 1;

	public ObjectLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public ObjectLiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ObjectLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ObjectLiteral;
	}

	public BooleanData getDestructuring() {
		return wGet(JavaScriptFeatureDescriptorEnum.destructuring).wGetAdapter(
				JavaScriptEntityDescriptorEnum.BooleanData);
	}

	public void setDestructuring(BooleanData destructuring) {
		wSet(JavaScriptFeatureDescriptorEnum.destructuring, destructuring);
	}

	public ObjectProperties getProperties() {
		return wGet(JavaScriptFeatureDescriptorEnum.properties).wGetAdapter(
				JavaScriptEntityDescriptorEnum.ObjectProperties);
	}

	public void setProperties(ObjectProperties properties) {
		wSet(JavaScriptFeatureDescriptorEnum.properties, properties);
	}
}
