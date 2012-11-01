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
public class StaticXmlRefAdapter extends AbstractEntityAdapter implements
		StaticXmlRef {
	private static final long serialVersionUID = 1;

	public StaticXmlRefAdapter(IEntity implementor) {
		super(implementor);
	}

	public StaticXmlRefAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StaticXmlRef> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.StaticXmlRef;
	}

	public BooleanData getAttribute() {
		return wGet(JavaScriptFeatureDescriptorEnum.attribute).wGetAdapter(
				JavaScriptEntityDescriptorEnum.BooleanData);
	}

	public void setAttribute(BooleanData attribute) {
		wSet(JavaScriptFeatureDescriptorEnum.attribute, attribute);
	}

	public IdentifierOrXmlAny getNamespace() {
		return wGet(JavaScriptFeatureDescriptorEnum.namespace).wGetAdapter(
				JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny);
	}

	public void setNamespace(IdentifierOrXmlAny namespace) {
		wSet(JavaScriptFeatureDescriptorEnum.namespace, namespace);
	}

	public IdentifierOrXmlAny getProperty() {
		return wGet(JavaScriptFeatureDescriptorEnum.property).wGetAdapter(
				JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny);
	}

	public void setProperty(IdentifierOrXmlAny property) {
		wSet(JavaScriptFeatureDescriptorEnum.property, property);
	}
}
