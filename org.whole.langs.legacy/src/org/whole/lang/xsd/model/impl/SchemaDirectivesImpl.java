package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SchemaDirectivesImpl extends
		AbstractListCompositeEntity<SchemaDirective> implements
		SchemaDirectives {
	private static final long serialVersionUID = 1;

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.SchemaDirectives_ord;
	}

	public EntityDescriptor<SchemaDirectives> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.SchemaDirectives;
	}
}
