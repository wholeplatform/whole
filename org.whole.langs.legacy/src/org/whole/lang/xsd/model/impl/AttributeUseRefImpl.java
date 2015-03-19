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
public class AttributeUseRefImpl extends AbstractSimpleEntity implements
		AttributeUseRef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AttributeUseRef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AttributeUseRef;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.AttributeUseRef_ord;
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

	private QName ref;

	public QName getRef() {
		return notifyRequested(XsdFeatureDescriptorEnum.ref, ref);
	}

	public void setRef(QName ref) {
		notifyChanged(XsdFeatureDescriptorEnum.ref, this.ref, this.ref = ref);
	}

	private Use use;

	public Use getUse() {
		return notifyRequested(XsdFeatureDescriptorEnum.use, use);
	}

	public void setUse(Use use) {
		notifyChanged(XsdFeatureDescriptorEnum.use, this.use, this.use = use);
	}

	private Qualify form;

	public Qualify getForm() {
		return notifyRequested(XsdFeatureDescriptorEnum.form, form);
	}

	public void setForm(Qualify form) {
		notifyChanged(XsdFeatureDescriptorEnum.form, this.form,
				this.form = form);
	}

	private StringData defaultValue;

	public StringData getDefaultValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.defaultValue,
				defaultValue);
	}

	public void setDefaultValue(StringData defaultValue) {
		notifyChanged(XsdFeatureDescriptorEnum.defaultValue, this.defaultValue,
				this.defaultValue = defaultValue);
	}

	private StringData fixedValue;

	public StringData getFixedValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.fixedValue, fixedValue);
	}

	public void setFixedValue(StringData fixedValue) {
		notifyChanged(XsdFeatureDescriptorEnum.fixedValue, this.fixedValue,
				this.fixedValue = fixedValue);
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
			return getRef().wGetAdaptee(false);
		case 4:
			return getUse().wGetAdaptee(false);
		case 5:
			return getForm().wGetAdaptee(false);
		case 6:
			return getDefaultValue().wGetAdaptee(false);
		case 7:
			return getFixedValue().wGetAdaptee(false);
		case 8:
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
			setRef(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 4:
			setUse(value.wGetAdapter(XsdEntityDescriptorEnum.Use));
			break;
		case 5:
			setForm(value.wGetAdapter(XsdEntityDescriptorEnum.Qualify));
			break;
		case 6:
			setDefaultValue(value
					.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 7:
			setFixedValue(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 8:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
