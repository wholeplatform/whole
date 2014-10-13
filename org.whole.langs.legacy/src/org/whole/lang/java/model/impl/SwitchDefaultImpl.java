package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;

/** 
 * @generator Whole
 */
public class SwitchDefaultImpl extends AbstractSimpleEntity implements
		SwitchDefault {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SwitchDefault> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SwitchDefault;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.SwitchDefault_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}
}
