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
public class DeclaredContentAdapter extends AbstractEntityAdapter implements
		DeclaredContent {
	private static final long serialVersionUID = 1;

	public DeclaredContentAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeclaredContentAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DeclaredContent> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.DeclaredContent;
	}

	public ModelGroup getModelGroup() {
		return wGet(XsdFeatureDescriptorEnum.modelGroup).wGetAdapter(
				XsdEntityDescriptorEnum.ModelGroup);
	}

	public void setModelGroup(ModelGroup modelGroup) {
		wSet(XsdFeatureDescriptorEnum.modelGroup, modelGroup);
	}

	public AttributeUseOrGroups getAttributeUses() {
		return wGet(XsdFeatureDescriptorEnum.attributeUses).wGetAdapter(
				XsdEntityDescriptorEnum.AttributeUseOrGroups);
	}

	public void setAttributeUses(AttributeUseOrGroups attributeUses) {
		wSet(XsdFeatureDescriptorEnum.attributeUses, attributeUses);
	}

	public AnyAttribute getAnyAttribute() {
		return wGet(XsdFeatureDescriptorEnum.anyAttribute).wGetAdapter(
				XsdEntityDescriptorEnum.AnyAttribute);
	}

	public void setAnyAttribute(AnyAttribute anyAttribute) {
		wSet(XsdFeatureDescriptorEnum.anyAttribute, anyAttribute);
	}
}
