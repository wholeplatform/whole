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
public class PackageDeclarationImpl extends AbstractSimpleEntity implements
		PackageDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PackageDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PackageDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.PackageDeclaration_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Javadoc javadoc;

	public Javadoc getJavadoc() {
		return notifyRequested(JavaFeatureDescriptorEnum.javadoc, javadoc);
	}

	public void setJavadoc(Javadoc javadoc) {
		notifyChanged(JavaFeatureDescriptorEnum.javadoc, this.javadoc,
				this.javadoc = javadoc);
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

	private Name name;

	public Name getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getJavadoc().wGetAdaptee(false);
		case 1:
			return getAnnotations().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setJavadoc(value.wGetAdapter(JavaEntityDescriptorEnum.Javadoc));
			break;
		case 1:
			setAnnotations(value
					.wGetAdapter(JavaEntityDescriptorEnum.Annotations));
			break;
		case 2:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
