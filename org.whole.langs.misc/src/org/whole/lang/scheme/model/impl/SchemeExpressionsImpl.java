package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SchemeExpressionsImpl extends
		AbstractListCompositeEntity<SchemeExpression> implements
		SchemeExpressions {
	private static final long serialVersionUID = 1;

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.SchemeExpressions_ord;
	}

	public EntityDescriptor<SchemeExpressions> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.SchemeExpressions;
	}
}
