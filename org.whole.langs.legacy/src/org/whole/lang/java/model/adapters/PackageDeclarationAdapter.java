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
public class PackageDeclarationAdapter extends AbstractEntityAdapter implements
		PackageDeclaration {
	private static final long serialVersionUID = 1;

	public PackageDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public PackageDeclarationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PackageDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PackageDeclaration;
	}

	public Javadoc getJavadoc() {
		return wGet(JavaFeatureDescriptorEnum.javadoc).wGetAdapter(
				JavaEntityDescriptorEnum.Javadoc);
	}

	public void setJavadoc(Javadoc javadoc) {
		wSet(JavaFeatureDescriptorEnum.javadoc, javadoc);
	}

	public Annotations getAnnotations() {
		return wGet(JavaFeatureDescriptorEnum.annotations).wGetAdapter(
				JavaEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(JavaFeatureDescriptorEnum.annotations, annotations);
	}

	public Name getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}
}
