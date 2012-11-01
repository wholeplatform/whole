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
public class AnnotationTypeAdapter extends AbstractEntityAdapter implements
		AnnotationType {
	private static final long serialVersionUID = 1;

	public AnnotationTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnnotationTypeAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnnotationType> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AnnotationType;
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

	public AnyURI getSource() {
		return wGet(XsdFeatureDescriptorEnum.source).wGetAdapter(
				XsdEntityDescriptorEnum.AnyURI);
	}

	public void setSource(AnyURI source) {
		wSet(XsdFeatureDescriptorEnum.source, source);
	}

	public AnnotationContents getContent() {
		return wGet(XsdFeatureDescriptorEnum.content).wGetAdapter(
				XsdEntityDescriptorEnum.AnnotationContents);
	}

	public void setContent(AnnotationContents content) {
		wSet(XsdFeatureDescriptorEnum.content, content);
	}
}
