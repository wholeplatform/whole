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
public class AnnotationTypeDeclarationImpl extends AbstractSimpleEntity
		implements AnnotationTypeDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnnotationTypeDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AnnotationTypeDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.AnnotationTypeDeclaration_ord;
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

	private ExtendedModifiers modifiers;

	public ExtendedModifiers getModifiers() {
		return notifyRequested(JavaFeatureDescriptorEnum.modifiers, modifiers);
	}

	public void setModifiers(ExtendedModifiers modifiers) {
		notifyChanged(JavaFeatureDescriptorEnum.modifiers, this.modifiers,
				this.modifiers = modifiers);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private BodyDeclarations bodyDeclarations;

	public BodyDeclarations getBodyDeclarations() {
		return notifyRequested(JavaFeatureDescriptorEnum.bodyDeclarations,
				bodyDeclarations);
	}

	public void setBodyDeclarations(BodyDeclarations bodyDeclarations) {
		notifyChanged(JavaFeatureDescriptorEnum.bodyDeclarations,
				this.bodyDeclarations, this.bodyDeclarations = bodyDeclarations);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getJavadoc().wGetAdaptee(false);
		case 1:
			return getModifiers().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getBodyDeclarations().wGetAdaptee(false);
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
			setModifiers(value
					.wGetAdapter(JavaEntityDescriptorEnum.ExtendedModifiers));
			break;
		case 2:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 3:
			setBodyDeclarations(value
					.wGetAdapter(JavaEntityDescriptorEnum.BodyDeclarations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
