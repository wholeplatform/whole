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
public class RegExpLiteralAdapter extends AbstractEntityAdapter implements
		RegExpLiteral {
	private static final long serialVersionUID = 1;

	public RegExpLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public RegExpLiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RegExpLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.RegExpLiteral;
	}

	public StringData getValue() {
		return wGet(JavaScriptFeatureDescriptorEnum.value).wGetAdapter(
				JavaScriptEntityDescriptorEnum.StringData);
	}

	public void setValue(StringData value) {
		wSet(JavaScriptFeatureDescriptorEnum.value, value);
	}

	public StringData getFlags() {
		return wGet(JavaScriptFeatureDescriptorEnum.flags).wGetAdapter(
				JavaScriptEntityDescriptorEnum.StringData);
	}

	public void setFlags(StringData flags) {
		wSet(JavaScriptFeatureDescriptorEnum.flags, flags);
	}
}
