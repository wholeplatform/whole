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
public class DocumentationAdapter extends AbstractEntityAdapter implements
		Documentation {
	private static final long serialVersionUID = 1;

	public DocumentationAdapter(IEntity implementor) {
		super(implementor);
	}

	public DocumentationAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Documentation> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Documentation;
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

	public XMLLanguageType getLanguage() {
		return wGet(XsdFeatureDescriptorEnum.language).wGetAdapter(
				XsdEntityDescriptorEnum.XMLLanguageType);
	}

	public void setLanguage(XMLLanguageType language) {
		wSet(XsdFeatureDescriptorEnum.language, language);
	}

	public AnnotationContents getContent() {
		return wGet(XsdFeatureDescriptorEnum.content).wGetAdapter(
				XsdEntityDescriptorEnum.AnnotationContents);
	}

	public void setContent(AnnotationContents content) {
		wSet(XsdFeatureDescriptorEnum.content, content);
	}
}
