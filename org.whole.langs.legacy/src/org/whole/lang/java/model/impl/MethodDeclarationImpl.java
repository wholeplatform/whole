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
public class MethodDeclarationImpl extends AbstractSimpleEntity implements
		MethodDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MethodDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MethodDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.MethodDeclaration_ord;
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

	private TypeParameters typeParameters;

	public TypeParameters getTypeParameters() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeParameters,
				typeParameters);
	}

	public void setTypeParameters(TypeParameters typeParameters) {
		notifyChanged(JavaFeatureDescriptorEnum.typeParameters,
				this.typeParameters, this.typeParameters = typeParameters);
	}

	private Type returnType;

	public Type getReturnType() {
		return notifyRequested(JavaFeatureDescriptorEnum.returnType, returnType);
	}

	public void setReturnType(Type returnType) {
		notifyChanged(JavaFeatureDescriptorEnum.returnType, this.returnType,
				this.returnType = returnType);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(JavaFeatureDescriptorEnum.parameters, parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(JavaFeatureDescriptorEnum.parameters, this.parameters,
				this.parameters = parameters);
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

	private Names thrownExceptions;

	public Names getThrownExceptions() {
		return notifyRequested(JavaFeatureDescriptorEnum.thrownExceptions,
				thrownExceptions);
	}

	public void setThrownExceptions(Names thrownExceptions) {
		notifyChanged(JavaFeatureDescriptorEnum.thrownExceptions,
				this.thrownExceptions, this.thrownExceptions = thrownExceptions);
	}

	private Block body;

	public Block getBody() {
		return notifyRequested(JavaFeatureDescriptorEnum.body, body);
	}

	public void setBody(Block body) {
		notifyChanged(JavaFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getJavadoc().wGetAdaptee(false);
		case 1:
			return getModifiers().wGetAdaptee(false);
		case 2:
			return getTypeParameters().wGetAdaptee(false);
		case 3:
			return getReturnType().wGetAdaptee(false);
		case 4:
			return getName().wGetAdaptee(false);
		case 5:
			return getParameters().wGetAdaptee(false);
		case 6:
			return getExtraDimensions().wGetAdaptee(false);
		case 7:
			return getThrownExceptions().wGetAdaptee(false);
		case 8:
			return getBody().wGetAdaptee(false);
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
			setTypeParameters(value
					.wGetAdapter(JavaEntityDescriptorEnum.TypeParameters));
			break;
		case 3:
			setReturnType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 4:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 5:
			setParameters(value
					.wGetAdapter(JavaEntityDescriptorEnum.Parameters));
			break;
		case 6:
			setExtraDimensions(value
					.wGetAdapter(JavaEntityDescriptorEnum.ExtraDimensions));
			break;
		case 7:
			setThrownExceptions(value
					.wGetAdapter(JavaEntityDescriptorEnum.Names));
			break;
		case 8:
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
