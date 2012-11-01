package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class OrExpressionsImpl extends
		AbstractListCompositeEntity<TypeExpressions> implements OrExpressions {
	private static final long serialVersionUID = 1;

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.OrExpressions_ord;
	}

	public EntityDescriptor<OrExpressions> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.OrExpressions;
	}
}
