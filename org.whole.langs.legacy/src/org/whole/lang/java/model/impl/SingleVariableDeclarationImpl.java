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
public class SingleVariableDeclarationImpl extends AbstractSimpleEntity
		implements SingleVariableDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SingleVariableDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SingleVariableDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.SingleVariableDeclaration_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
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

	private Varargs varargs;

	public Varargs getVarargs() {
		return notifyRequested(JavaFeatureDescriptorEnum.varargs, varargs);
	}

	public void setVarargs(Varargs varargs) {
		notifyChanged(JavaFeatureDescriptorEnum.varargs, this.varargs,
				this.varargs = varargs);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private ExtraDimensions extraDimensions;

	public ExtraDimensions getExtraDimensions() {
		return notifyRequested(JavaFeatureDescriptorEnum.extraDimensions,
				extraDimensions);
	}

	public void setExtraDimensions(ExtraDimensions extraDimensions) {
		notifyChanged(JavaFeatureDescriptorEnum.extraDimensions,
				this.extraDimensions, this.extraDimensions = extraDimensions);
	}

	private Expression initializer;

	public Expression getInitializer() {
		return notifyRequested(JavaFeatureDescriptorEnum.initializer,
				initializer);
	}

	public void setInitializer(Expression initializer) {
		notifyChanged(JavaFeatureDescriptorEnum.initializer, this.initializer,
				this.initializer = initializer);
	}

	private Annotations varargsAnnotations;

	public Annotations getVarargsAnnotations() {
		return notifyRequested(JavaFeatureDescriptorEnum.varargsAnnotations,
				varargsAnnotations);
	}

	public void setVarargsAnnotations(Annotations varargsAnnotations) {
		notifyChanged(JavaFeatureDescriptorEnum.varargsAnnotations,
				this.varargsAnnotations,
				this.varargsAnnotations = varargsAnnotations);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getModifiers().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		case 2:
			return getVarargs().wGetAdaptee(false);
		case 3:
			return getName().wGetAdaptee(false);
		case 4:
			return getExtraDimensions().wGetAdaptee(false);
		case 5:
			return getInitializer().wGetAdaptee(false);
		case 6:
			return getVarargsAnnotations().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setModifiers(value
					.wGetAdapter(JavaEntityDescriptorEnum.ExtendedModifiers));
			break;
		case 1:
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 2:
			setVarargs(value.wGetAdapter(JavaEntityDescriptorEnum.Varargs));
			break;
		case 3:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 4:
			setExtraDimensions(value
					.wGetAdapter(JavaEntityDescriptorEnum.ExtraDimensions));
			break;
		case 5:
			setInitializer(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 6:
			setVarargsAnnotations(value
					.wGetAdapter(JavaEntityDescriptorEnum.Annotations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 7;
	}
}
