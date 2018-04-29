package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArrayAccessAdapter extends AbstractEntityAdapter implements ArrayAccess {
	private static final long serialVersionUID = 1;

	public ArrayAccessAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayAccessAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayAccess> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ArrayAccess;
	}

	public Expression getArray() {
		return wGet(ImpFeatureDescriptorEnum.array).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setArray(Expression array) {
		wSet(ImpFeatureDescriptorEnum.array, array);
	}

	public Expression getIndex() {
		return wGet(ImpFeatureDescriptorEnum.index).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setIndex(Expression index) {
		wSet(ImpFeatureDescriptorEnum.index, index);
	}
}
