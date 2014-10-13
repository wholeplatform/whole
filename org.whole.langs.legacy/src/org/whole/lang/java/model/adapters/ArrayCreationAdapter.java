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
public class ArrayCreationAdapter extends AbstractEntityAdapter implements
		ArrayCreation {
	private static final long serialVersionUID = 1;

	public ArrayCreationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayCreationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayCreation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayCreation;
	}

	public ArrayType getType() {
		return wGet(JavaFeatureDescriptorEnum.type).wGetAdapter(
				JavaEntityDescriptorEnum.ArrayType);
	}

	public void setType(ArrayType type) {
		wSet(JavaFeatureDescriptorEnum.type, type);
	}

	public Expressions getDimensions() {
		return wGet(JavaFeatureDescriptorEnum.dimensions).wGetAdapter(
				JavaEntityDescriptorEnum.Expressions);
	}

	public void setDimensions(Expressions dimensions) {
		wSet(JavaFeatureDescriptorEnum.dimensions, dimensions);
	}

	public ArrayInitializer getInitializer() {
		return wGet(JavaFeatureDescriptorEnum.initializer).wGetAdapter(
				JavaEntityDescriptorEnum.ArrayInitializer);
	}

	public void setInitializer(ArrayInitializer initializer) {
		wSet(JavaFeatureDescriptorEnum.initializer, initializer);
	}
}
