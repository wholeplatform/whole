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
public class NormalAnnotationImpl extends AbstractSimpleEntity implements
		NormalAnnotation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NormalAnnotation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.NormalAnnotation;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.NormalAnnotation_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Name typeName;

	public Name getTypeName() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeName, typeName);
	}

	public void setTypeName(Name typeName) {
		notifyChanged(JavaFeatureDescriptorEnum.typeName, this.typeName,
				this.typeName = typeName);
	}

	private MemberValuePairs values;

	public MemberValuePairs getValues() {
		return notifyRequested(JavaFeatureDescriptorEnum.values, values);
	}

	public void setValues(MemberValuePairs values) {
		notifyChanged(JavaFeatureDescriptorEnum.values, this.values,
				this.values = values);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTypeName().wGetAdaptee(false);
		case 1:
			return getValues().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTypeName(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
			break;
		case 1:
			setValues(value
					.wGetAdapter(JavaEntityDescriptorEnum.MemberValuePairs));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
