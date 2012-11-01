package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class BreakStatementImpl extends AbstractSimpleEntity implements
		BreakStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<BreakStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BreakStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.BreakStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private SimpleName label;

	public SimpleName getLabel() {
		return notifyRequested(JavaFeatureDescriptorEnum.label, label);
	}

	public void setLabel(SimpleName label) {
		notifyChanged(JavaFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabel(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
