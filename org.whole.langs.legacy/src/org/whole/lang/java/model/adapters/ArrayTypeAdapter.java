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
public class ArrayTypeAdapter extends AbstractEntityAdapter implements
		ArrayType {
	private static final long serialVersionUID = 1;

	public ArrayTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayTypeAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayType;
	}

	public Type getComponentType() {
		return wGet(JavaFeatureDescriptorEnum.componentType).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setComponentType(Type componentType) {
		wSet(JavaFeatureDescriptorEnum.componentType, componentType);
	}
}
