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
public class EnumConstantDeclarationImpl extends AbstractSimpleEntity implements
		EnumConstantDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EnumConstantDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.EnumConstantDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.EnumConstantDeclaration_ord;
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

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(JavaFeatureDescriptorEnum.arguments, arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(JavaFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	private AnonymousClassDeclaration anonymousClassDeclaration;

	public AnonymousClassDeclaration getAnonymousClassDeclaration() {
		return notifyRequested(
				JavaFeatureDescriptorEnum.anonymousClassDeclaration,
				anonymousClassDeclaration);
	}

	public void setAnonymousClassDeclaration(
			AnonymousClassDeclaration anonymousClassDeclaration) {
		notifyChanged(JavaFeatureDescriptorEnum.anonymousClassDeclaration,
				this.anonymousClassDeclaration,
				this.anonymousClassDeclaration = anonymousClassDeclaration);
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
			return getArguments().wGetAdaptee(false);
		case 4:
			return getAnonymousClassDeclaration().wGetAdaptee(false);
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
			setArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Arguments));
			break;
		case 4:
			setAnonymousClassDeclaration(value
					.wGetAdapter(JavaEntityDescriptorEnum.AnonymousClassDeclaration));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
