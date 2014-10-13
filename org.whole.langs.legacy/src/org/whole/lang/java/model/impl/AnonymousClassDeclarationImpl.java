package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class AnonymousClassDeclarationImpl extends
		AbstractListCompositeEntity<BodyDeclaration> implements
		AnonymousClassDeclaration {
	private static final long serialVersionUID = 1;

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.AnonymousClassDeclaration_ord;
	}

	public EntityDescriptor<AnonymousClassDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AnonymousClassDeclaration;
	}
}
