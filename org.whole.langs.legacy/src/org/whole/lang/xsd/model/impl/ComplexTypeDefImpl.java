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
public class ComplexTypeDefImpl extends AbstractSimpleEntity implements
		ComplexTypeDef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ComplexTypeDef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ComplexTypeDef;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.ComplexTypeDef_ord;
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
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

	private DerivationSet _final;

	public DerivationSet getFinal() {
		return notifyRequested(XsdFeatureDescriptorEnum._final, _final);
	}

	public void setFinal(DerivationSet _final) {
		notifyChanged(XsdFeatureDescriptorEnum._final, this._final,
				this._final = _final);
	}

	private BooleanData _abstract;

	public BooleanData getAbstract() {
		return notifyRequested(XsdFeatureDescriptorEnum._abstract, _abstract);
	}

	public void setAbstract(BooleanData _abstract) {
		notifyChanged(XsdFeatureDescriptorEnum._abstract, this._abstract,
				this._abstract = _abstract);
	}

	private BooleanData mixed;

	public BooleanData getMixed() {
		return notifyRequested(XsdFeatureDescriptorEnum.mixed, mixed);
	}

	public void setMixed(BooleanData mixed) {
		notifyChanged(XsdFeatureDescriptorEnum.mixed, this.mixed,
				this.mixed = mixed);
	}

	private DerivationSet block;

	public DerivationSet getBlock() {
		return notifyRequested(XsdFeatureDescriptorEnum.block, block);
	}

	public void setBlock(DerivationSet block) {
		notifyChanged(XsdFeatureDescriptorEnum.block, this.block,
				this.block = block);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private ComplexTypeContent content;

	public ComplexTypeContent getContent() {
		return notifyRequested(XsdFeatureDescriptorEnum.content, content);
	}

	public void setContent(ComplexTypeContent content) {
		notifyChanged(XsdFeatureDescriptorEnum.content, this.content,
				this.content = content);
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
			return getFinal().wGetAdaptee(false);
		case 5:
			return getAbstract().wGetAdaptee(false);
		case 6:
			return getMixed().wGetAdaptee(false);
		case 7:
			return getBlock().wGetAdaptee(false);
		case 8:
			return getAnnotation().wGetAdaptee(false);
		case 9:
			return getContent().wGetAdaptee(false);
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
			setFinal(value.wGetAdapter(XsdEntityDescriptorEnum.DerivationSet));
			break;
		case 5:
			setAbstract(value.wGetAdapter(XsdEntityDescriptorEnum.BooleanData));
			break;
		case 6:
			setMixed(value.wGetAdapter(XsdEntityDescriptorEnum.BooleanData));
			break;
		case 7:
			setBlock(value.wGetAdapter(XsdEntityDescriptorEnum.DerivationSet));
			break;
		case 8:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 9:
			setContent(value
					.wGetAdapter(XsdEntityDescriptorEnum.ComplexTypeContent));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 10;
	}
}
