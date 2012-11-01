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
public class MemberRefImpl extends AbstractSimpleEntity implements MemberRef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MemberRef> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MemberRef;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.MemberRef_ord;
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

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getQualifier().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setQualifier(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
			break;
		case 1:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
