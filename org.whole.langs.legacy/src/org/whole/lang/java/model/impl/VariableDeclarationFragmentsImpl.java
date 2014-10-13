package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VariableDeclarationFragmentsImpl extends
		AbstractListCompositeEntity<VariableDeclarationFragment> implements
		VariableDeclarationFragments {
	private static final long serialVersionUID = 1;

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.VariableDeclarationFragments_ord;
	}

	public EntityDescriptor<VariableDeclarationFragments> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.VariableDeclarationFragments;
	}
}
