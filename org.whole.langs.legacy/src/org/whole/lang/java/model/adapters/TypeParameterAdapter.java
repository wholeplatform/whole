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
public class TypeParameterAdapter extends AbstractEntityAdapter implements
		TypeParameter {
	private static final long serialVersionUID = 1;

	public TypeParameterAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeParameterAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeParameter> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeParameter;
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public Types getTypeBounds() {
		return wGet(JavaFeatureDescriptorEnum.typeBounds).wGetAdapter(
				JavaEntityDescriptorEnum.Types);
	}

	public void setTypeBounds(Types typeBounds) {
		wSet(JavaFeatureDescriptorEnum.typeBounds, typeBounds);
	}

	public Annotations getAnnotations() {
		return wGet(JavaFeatureDescriptorEnum.annotations).wGetAdapter(
				JavaEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(JavaFeatureDescriptorEnum.annotations, annotations);
	}
}
