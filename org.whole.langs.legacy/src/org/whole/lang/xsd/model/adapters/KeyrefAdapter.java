package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class KeyrefAdapter extends AbstractEntityAdapter implements Keyref {
	private static final long serialVersionUID = 1;

	public KeyrefAdapter(IEntity implementor) {
		super(implementor);
	}

	public KeyrefAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Keyref> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Keyref;
	}

	public NamespaceDecls getNamespaces() {
		return wGet(XsdFeatureDescriptorEnum.namespaces).wGetAdapter(
				XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		wSet(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public StringData getId() {
		return wGet(XsdFeatureDescriptorEnum.id).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setId(StringData id) {
		wSet(XsdFeatureDescriptorEnum.id, id);
	}

	public Attributes getAttributes() {
		return wGet(XsdFeatureDescriptorEnum.attributes).wGetAdapter(
				XsdEntityDescriptorEnum.Attributes);
	}

	public void setAttributes(Attributes attributes) {
		wSet(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public Name getName() {
		return wGet(XsdFeatureDescriptorEnum.name).wGetAdapter(
				XsdEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(XsdFeatureDescriptorEnum.name, name);
	}

	public QName getRefer() {
		return wGet(XsdFeatureDescriptorEnum.refer).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setRefer(QName refer) {
		wSet(XsdFeatureDescriptorEnum.refer, refer);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public Selector getSelector() {
		return wGet(XsdFeatureDescriptorEnum.selector).wGetAdapter(
				XsdEntityDescriptorEnum.Selector);
	}

	public void setSelector(Selector selector) {
		wSet(XsdFeatureDescriptorEnum.selector, selector);
	}

	public Fields getFields() {
		return wGet(XsdFeatureDescriptorEnum.fields).wGetAdapter(
				XsdEntityDescriptorEnum.Fields);
	}

	public void setFields(Fields fields) {
		wSet(XsdFeatureDescriptorEnum.fields, fields);
	}
}
