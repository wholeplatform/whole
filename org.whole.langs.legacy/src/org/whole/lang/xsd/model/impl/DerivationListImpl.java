package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DerivationListImpl extends
		AbstractCollectionCompositeEntity<DerivationControl> implements
		DerivationList {
	private static final long serialVersionUID = 1;

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.DerivationList_ord;
	}

	public EntityDescriptor<DerivationList> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.DerivationList;
	}
}
