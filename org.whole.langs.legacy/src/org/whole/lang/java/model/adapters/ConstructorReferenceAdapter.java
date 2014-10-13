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
public class ConstructorReferenceAdapter extends AbstractEntityAdapter
		implements ConstructorReference {
	private static final long serialVersionUID = 1;

	public ConstructorReferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConstructorReferenceAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConstructorReference> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ConstructorReference;
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
}
