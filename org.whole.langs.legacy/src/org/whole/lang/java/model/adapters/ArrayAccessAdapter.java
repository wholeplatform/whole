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
public class ArrayAccessAdapter extends AbstractEntityAdapter implements
		ArrayAccess {
	private static final long serialVersionUID = 1;

	public ArrayAccessAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayAccessAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayAccess> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayAccess;
	}

	public Expression getArray() {
		return wGet(JavaFeatureDescriptorEnum.array).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setArray(Expression array) {
		wSet(JavaFeatureDescriptorEnum.array, array);
	}

	public Expression getIndex() {
		return wGet(JavaFeatureDescriptorEnum.index).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setIndex(Expression index) {
		wSet(JavaFeatureDescriptorEnum.index, index);
	}
}
