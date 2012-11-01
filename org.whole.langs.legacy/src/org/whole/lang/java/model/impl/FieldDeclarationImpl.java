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
public class FieldDeclarationImpl extends AbstractSimpleEntity implements
		FieldDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FieldDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.FieldDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.FieldDeclaration_ord;
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

	private Type type;

	public Type getType() {
		return notifyRequested(JavaFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(JavaFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private VariableDeclarationFragments fragments;

	public VariableDeclarationFragments getFragments() {
		return notifyRequested(JavaFeatureDescriptorEnum.fragments, fragments);
	}

	public void setFragments(VariableDeclarationFragments fragments) {
		notifyChanged(JavaFeatureDescriptorEnum.fragments, this.fragments,
				this.fragments = fragments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getJavadoc().wGetAdaptee(false);
		case 1:
			return getModifiers().wGetAdaptee(false);
		case 2:
			return getType().wGetAdaptee(false);
		case 3:
			return getFragments().wGetAdaptee(false);
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
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 3:
			setFragments(value
					.wGetAdapter(JavaEntityDescriptorEnum.VariableDeclarationFragments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
