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
public class StringLiteralAdapter extends AbstractEntityAdapter implements
		StringLiteral {
	private static final long serialVersionUID = 1;

	public StringLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringLiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.StringLiteral;
	}

	public StringData getValue() {
		return wGet(JavaScriptFeatureDescriptorEnum.value).wGetAdapter(
				JavaScriptEntityDescriptorEnum.StringData);
	}

	public void setValue(StringData value) {
		wSet(JavaScriptFeatureDescriptorEnum.value, value);
	}

	public StringData getQuote() {
		return wGet(JavaScriptFeatureDescriptorEnum.quote).wGetAdapter(
				JavaScriptEntityDescriptorEnum.StringData);
	}

	public void setQuote(StringData quote) {
		wSet(JavaScriptFeatureDescriptorEnum.quote, quote);
	}
}
