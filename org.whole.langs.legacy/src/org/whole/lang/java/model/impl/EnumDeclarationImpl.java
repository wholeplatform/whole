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
public class EnumDeclarationImpl extends AbstractSimpleEntity implements
		EnumDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EnumDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.EnumDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.EnumDeclaration_ord;
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

	private Types superInterfaceTypes;

	public Types getSuperInterfaceTypes() {
		return notifyRequested(JavaFeatureDescriptorEnum.superInterfaceTypes,
				superInterfaceTypes);
	}

	public void setSuperInterfaceTypes(Types superInterfaceTypes) {
		notifyChanged(JavaFeatureDescriptorEnum.superInterfaceTypes,
				this.superInterfaceTypes,
				this.superInterfaceTypes = superInterfaceTypes);
	}

	private EnumConstants enumConstants;

	public EnumConstants getEnumConstants() {
		return notifyRequested(JavaFeatureDescriptorEnum.enumConstants,
				enumConstants);
	}

	public void setEnumConstants(EnumConstants enumConstants) {
		notifyChanged(JavaFeatureDescriptorEnum.enumConstants,
				this.enumConstants, this.enumConstants = enumConstants);
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
			return getSuperInterfaceTypes().wGetAdaptee(false);
		case 4:
			return getEnumConstants().wGetAdaptee(false);
		case 5:
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
			setSuperInterfaceTypes(value
					.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		case 4:
			setEnumConstants(value
					.wGetAdapter(JavaEntityDescriptorEnum.EnumConstants));
			break;
		case 5:
			setBodyDeclarations(value
					.wGetAdapter(JavaEntityDescriptorEnum.BodyDeclarations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
