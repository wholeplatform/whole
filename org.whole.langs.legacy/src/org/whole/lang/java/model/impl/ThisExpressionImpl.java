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
public class ThisExpressionImpl extends AbstractSimpleEntity implements
		ThisExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ThisExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ThisExpression;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ThisExpression_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Name qualifier;

	public Name getQualifier() {
		return notifyRequested(JavaFeatureDescriptorEnum.qualifier, qualifier);
	}

	public void setQualifier(Name qualifier) {
		notifyChanged(JavaFeatureDescriptorEnum.qualifier, this.qualifier,
				this.qualifier = qualifier);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getQualifier().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setQualifier(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
