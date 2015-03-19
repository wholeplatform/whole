package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class NotationDeclImpl extends AbstractSimpleEntity implements
		NotationDecl {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NotationDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.NotationDecl;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.NotationDecl_ord;
	}

	public void accept(IXsdVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private NamespaceDecls namespaces;

	public NamespaceDecls getNamespaces() {
		return notifyRequested(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		notifyChanged(XsdFeatureDescriptorEnum.namespaces, this.namespaces,
				this.namespaces = namespaces);
	}

	private StringData id;

	public StringData getId() {
		return notifyRequested(XsdFeatureDescriptorEnum.id, id);
	}

	public void setId(StringData id) {
		notifyChanged(XsdFeatureDescriptorEnum.id, this.id, this.id = id);
	}

	private Attributes attributes;

	public Attributes getAttributes() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public void setAttributes(Attributes attributes) {
		notifyChanged(XsdFeatureDescriptorEnum.attributes, this.attributes,
				this.attributes = attributes);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(XsdFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(XsdFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private StringData _public;

	public StringData getPublic() {
		return notifyRequested(XsdFeatureDescriptorEnum._public, _public);
	}

	public void setPublic(StringData _public) {
		notifyChanged(XsdFeatureDescriptorEnum._public, this._public,
				this._public = _public);
	}

	private AnyURI system;

	public AnyURI getSystem() {
		return notifyRequested(XsdFeatureDescriptorEnum.system, system);
	}

	public void setSystem(AnyURI system) {
		notifyChanged(XsdFeatureDescriptorEnum.system, this.system,
				this.system = system);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNamespaces().wGetAdaptee(false);
		case 1:
			return getId().wGetAdaptee(false);
		case 2:
			return getAttributes().wGetAdaptee(false);
		case 3:
			return getName().wGetAdaptee(false);
		case 4:
			return getPublic().wGetAdaptee(false);
		case 5:
			return getSystem().wGetAdaptee(false);
		case 6:
			return getAnnotation().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNamespaces(value
					.wGetAdapter(XsdEntityDescriptorEnum.NamespaceDecls));
			break;
		case 1:
			setId(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 2:
			setAttributes(value.wGetAdapter(XsdEntityDescriptorEnum.Attributes));
			break;
		case 3:
			setName(value.wGetAdapter(XsdEntityDescriptorEnum.Name));
			break;
		case 4:
			setPublic(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 5:
			setSystem(value.wGetAdapter(XsdEntityDescriptorEnum.AnyURI));
			break;
		case 6:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 7;
	}
}
