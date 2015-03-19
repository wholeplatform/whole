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
public class ListImpl extends AbstractSimpleEntity implements List {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<List> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.List;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.List_ord;
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

	private QName itemType;

	public QName getItemType() {
		return notifyRequested(XsdFeatureDescriptorEnum.itemType, itemType);
	}

	public void setItemType(QName itemType) {
		notifyChanged(XsdFeatureDescriptorEnum.itemType, this.itemType,
				this.itemType = itemType);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private SimpleTypeDef itemTypeDef;

	public SimpleTypeDef getItemTypeDef() {
		return notifyRequested(XsdFeatureDescriptorEnum.itemTypeDef,
				itemTypeDef);
	}

	public void setItemTypeDef(SimpleTypeDef itemTypeDef) {
		notifyChanged(XsdFeatureDescriptorEnum.itemTypeDef, this.itemTypeDef,
				this.itemTypeDef = itemTypeDef);
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
			return getItemType().wGetAdaptee(false);
		case 4:
			return getAnnotation().wGetAdaptee(false);
		case 5:
			return getItemTypeDef().wGetAdaptee(false);
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
			setItemType(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 4:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 5:
			setItemTypeDef(value
					.wGetAdapter(XsdEntityDescriptorEnum.SimpleTypeDef));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
