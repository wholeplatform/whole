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
public class MethodReferenceAdapter extends AbstractEntityAdapter implements
		MethodReference {
	private static final long serialVersionUID = 1;

	public MethodReferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public MethodReferenceAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MethodReference> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MethodReference;
	}

	public Types getTypeArguments() {
		return wGet(JavaFeatureDescriptorEnum.typeArguments).wGetAdapter(
				JavaEntityDescriptorEnum.Types);
	}

	public void setTypeArguments(Types typeArguments) {
		wSet(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
	}
}
