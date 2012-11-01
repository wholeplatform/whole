package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MemberTypesStrictImpl extends AbstractBagCompositeEntity<QName>
		implements MemberTypes {
	private static final long serialVersionUID = 1;

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.MemberTypes_ord;
	}

	public EntityDescriptor<MemberTypes> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.MemberTypes;
	}
}
