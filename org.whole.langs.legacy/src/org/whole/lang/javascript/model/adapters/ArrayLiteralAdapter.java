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
public class ArrayLiteralAdapter extends AbstractEntityAdapter implements
		ArrayLiteral {
	private static final long serialVersionUID = 1;

	public ArrayLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayLiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ArrayLiteral;
	}

	public BooleanData getDestructuring() {
		return wGet(JavaScriptFeatureDescriptorEnum.destructuring).wGetAdapter(
				JavaScriptEntityDescriptorEnum.BooleanData);
	}

	public void setDestructuring(BooleanData destructuring) {
		wSet(JavaScriptFeatureDescriptorEnum.destructuring, destructuring);
	}

	public Expressions getElements() {
		return wGet(JavaScriptFeatureDescriptorEnum.elements).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void setElements(Expressions elements) {
		wSet(JavaScriptFeatureDescriptorEnum.elements, elements);
	}
}
