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
public class AnnotatedTypeImpl extends AbstractSimpleEntity implements
		AnnotatedType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnnotatedType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AnnotatedType;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.AnnotatedType_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Annotations annotations;

	public Annotations getAnnotations() {
		return notifyRequested(JavaFeatureDescriptorEnum.annotations,
				annotations);
	}

	public void setAnnotations(Annotations annotations) {
		notifyChanged(JavaFeatureDescriptorEnum.annotations, this.annotations,
				this.annotations = annotations);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(JavaFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(JavaFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAnnotations().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAnnotations(value
					.wGetAdapter(JavaEntityDescriptorEnum.Annotations));
			break;
		case 1:
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
