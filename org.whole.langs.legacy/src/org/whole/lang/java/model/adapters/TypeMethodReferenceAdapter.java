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
public class TypeMethodReferenceAdapter extends AbstractEntityAdapter implements
		TypeMethodReference {
	private static final long serialVersionUID = 1;

	public TypeMethodReferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeMethodReferenceAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeMethodReference> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeMethodReference;
	}

	public Type getType() {
		return wGet(JavaFeatureDescriptorEnum.type).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(JavaFeatureDescriptorEnum.type, type);
	}

	public Types getTypeArguments() {
		return wGet(JavaFeatureDescriptorEnum.typeArguments).wGetAdapter(
				JavaEntityDescriptorEnum.Types);
	}

	public void setTypeArguments(Types typeArguments) {
		wSet(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}
}
