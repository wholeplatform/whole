package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SimpleTypeDefsImpl extends
		AbstractListCompositeEntity<SimpleTypeDef> implements SimpleTypeDefs {
	private static final long serialVersionUID = 1;

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.SimpleTypeDefs_ord;
	}

	public EntityDescriptor<SimpleTypeDefs> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.SimpleTypeDefs;
	}
}
