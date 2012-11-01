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
public class AttributeUseAdapter extends AbstractEntityAdapter implements
		AttributeUse {
	private static final long serialVersionUID = 1;

	public AttributeUseAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeUseAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AttributeUse> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AttributeUse;
	}

	public Use getUse() {
		return wGet(XsdFeatureDescriptorEnum.use).wGetAdapter(
				XsdEntityDescriptorEnum.Use);
	}

	public void setUse(Use use) {
		wSet(XsdFeatureDescriptorEnum.use, use);
	}

	public Qualify getForm() {
		return wGet(XsdFeatureDescriptorEnum.form).wGetAdapter(
				XsdEntityDescriptorEnum.Qualify);
	}

	public void setForm(Qualify form) {
		wSet(XsdFeatureDescriptorEnum.form, form);
	}
}
