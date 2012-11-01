package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class NamespaceSpecsListStrictImpl extends
		AbstractBagCompositeEntity<NamespaceSpec> implements NamespaceSpecsList {
	private static final long serialVersionUID = 1;

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.NamespaceSpecsList_ord;
	}

	public EntityDescriptor<NamespaceSpecsList> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.NamespaceSpecsList;
	}
}
