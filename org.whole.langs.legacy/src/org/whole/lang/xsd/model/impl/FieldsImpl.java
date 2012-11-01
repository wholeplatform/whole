package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FieldsImpl extends AbstractCollectionCompositeEntity<Field>
		implements Fields {
	private static final long serialVersionUID = 1;

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.Fields_ord;
	}

	public EntityDescriptor<Fields> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Fields;
	}
}
