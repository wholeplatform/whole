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
public class ObjectPropertyAdapter extends AbstractEntityAdapter implements
		ObjectProperty {
	private static final long serialVersionUID = 1;

	public ObjectPropertyAdapter(IEntity implementor) {
		super(implementor);
	}

	public ObjectPropertyAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ObjectProperty> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ObjectProperty;
	}

	public LiteralOrIdentifier getKey() {
		return wGet(JavaScriptFeatureDescriptorEnum.key).wGetAdapter(
				JavaScriptEntityDescriptorEnum.LiteralOrIdentifier);
	}

	public void setKey(LiteralOrIdentifier key) {
		wSet(JavaScriptFeatureDescriptorEnum.key, key);
	}

	public Expression getValue() {
		return wGet(JavaScriptFeatureDescriptorEnum.value).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setValue(Expression value) {
		wSet(JavaScriptFeatureDescriptorEnum.value, value);
	}
}
