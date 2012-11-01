package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BodyDeclarationsImpl extends
		AbstractListCompositeEntity<BodyDeclaration> implements
		BodyDeclarations {
	private static final long serialVersionUID = 1;

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.BodyDeclarations_ord;
	}

	public EntityDescriptor<BodyDeclarations> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BodyDeclarations;
	}
}
