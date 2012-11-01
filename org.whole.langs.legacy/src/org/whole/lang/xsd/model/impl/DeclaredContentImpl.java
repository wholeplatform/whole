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
public class DeclaredContentImpl extends AbstractSimpleEntity implements
		DeclaredContent {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DeclaredContent> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.DeclaredContent;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.DeclaredContent_ord;
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	private ModelGroup modelGroup;

	public ModelGroup getModelGroup() {
		return notifyRequested(XsdFeatureDescriptorEnum.modelGroup, modelGroup);
	}

	public void setModelGroup(ModelGroup modelGroup) {
		notifyChanged(XsdFeatureDescriptorEnum.modelGroup, this.modelGroup,
				this.modelGroup = modelGroup);
	}

	private AttributeUseOrGroups attributeUses;

	public AttributeUseOrGroups getAttributeUses() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributeUses,
				attributeUses);
	}

	public void setAttributeUses(AttributeUseOrGroups attributeUses) {
		notifyChanged(XsdFeatureDescriptorEnum.attributeUses,
				this.attributeUses, this.attributeUses = attributeUses);
	}

	private AnyAttribute anyAttribute;

	public AnyAttribute getAnyAttribute() {
		return notifyRequested(XsdFeatureDescriptorEnum.anyAttribute,
				anyAttribute);
	}

	public void setAnyAttribute(AnyAttribute anyAttribute) {
		notifyChanged(XsdFeatureDescriptorEnum.anyAttribute, this.anyAttribute,
				this.anyAttribute = anyAttribute);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getModelGroup().wGetAdaptee(false);
		case 1:
			return getAttributeUses().wGetAdaptee(false);
		case 2:
			return getAnyAttribute().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setModelGroup(value.wGetAdapter(XsdEntityDescriptorEnum.ModelGroup));
			break;
		case 1:
			setAttributeUses(value
					.wGetAdapter(XsdEntityDescriptorEnum.AttributeUseOrGroups));
			break;
		case 2:
			setAnyAttribute(value
					.wGetAdapter(XsdEntityDescriptorEnum.AnyAttribute));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
