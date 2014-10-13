package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SingleVariableDeclarationAdapter extends AbstractEntityAdapter
		implements SingleVariableDeclaration {
	private static final long serialVersionUID = 1;

	public SingleVariableDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SingleVariableDeclarationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SingleVariableDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SingleVariableDeclaration;
	}

	public ExtendedModifiers getModifiers() {
		return wGet(JavaFeatureDescriptorEnum.modifiers).wGetAdapter(
				JavaEntityDescriptorEnum.ExtendedModifiers);
	}

	public void setModifiers(ExtendedModifiers modifiers) {
		wSet(JavaFeatureDescriptorEnum.modifiers, modifiers);
	}

	public Type getType() {
		return wGet(JavaFeatureDescriptorEnum.type).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(JavaFeatureDescriptorEnum.type, type);
	}

	public Varargs getVarargs() {
		return wGet(JavaFeatureDescriptorEnum.varargs).wGetAdapter(
				JavaEntityDescriptorEnum.Varargs);
	}

	public void setVarargs(Varargs varargs) {
		wSet(JavaFeatureDescriptorEnum.varargs, varargs);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public ExtraDimensions getExtraDimensions() {
		return wGet(JavaFeatureDescriptorEnum.extraDimensions).wGetAdapter(
				JavaEntityDescriptorEnum.ExtraDimensions);
	}

	public void setExtraDimensions(ExtraDimensions extraDimensions) {
		wSet(JavaFeatureDescriptorEnum.extraDimensions, extraDimensions);
	}

	public Expression getInitializer() {
		return wGet(JavaFeatureDescriptorEnum.initializer).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setInitializer(Expression initializer) {
		wSet(JavaFeatureDescriptorEnum.initializer, initializer);
	}

	public Annotations getVarargsAnnotations() {
		return wGet(JavaFeatureDescriptorEnum.varargsAnnotations).wGetAdapter(
				JavaEntityDescriptorEnum.Annotations);
	}

	public void setVarargsAnnotations(Annotations varargsAnnotations) {
		wSet(JavaFeatureDescriptorEnum.varargsAnnotations, varargsAnnotations);
	}
}
