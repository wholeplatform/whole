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
public class TypeDeclarationAdapter extends AbstractEntityAdapter implements
		TypeDeclaration {
	private static final long serialVersionUID = 1;

	public TypeDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeDeclarationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeDeclaration;
	}

	public Javadoc getJavadoc() {
		return wGet(JavaFeatureDescriptorEnum.javadoc).wGetAdapter(
				JavaEntityDescriptorEnum.Javadoc);
	}

	public void setJavadoc(Javadoc javadoc) {
		wSet(JavaFeatureDescriptorEnum.javadoc, javadoc);
	}

	public ExtendedModifiers getModifiers() {
		return wGet(JavaFeatureDescriptorEnum.modifiers).wGetAdapter(
				JavaEntityDescriptorEnum.ExtendedModifiers);
	}

	public void setModifiers(ExtendedModifiers modifiers) {
		wSet(JavaFeatureDescriptorEnum.modifiers, modifiers);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public BodyDeclarations getBodyDeclarations() {
		return wGet(JavaFeatureDescriptorEnum.bodyDeclarations).wGetAdapter(
				JavaEntityDescriptorEnum.BodyDeclarations);
	}

	public void setBodyDeclarations(BodyDeclarations bodyDeclarations) {
		wSet(JavaFeatureDescriptorEnum.bodyDeclarations, bodyDeclarations);
	}
}
