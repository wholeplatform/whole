package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IntersectionTypeStrictImpl extends
		AbstractBagCompositeEntity<Type> implements IntersectionType {
	private static final long serialVersionUID = 1;

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.IntersectionType_ord;
	}

	public EntityDescriptor<IntersectionType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.IntersectionType;
	}
}
