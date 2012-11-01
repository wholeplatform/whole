package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Integer;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IntegerAdapter extends AbstractEntityAdapter implements Integer {
	private static final long serialVersionUID = 1;

	public IntegerAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntegerAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Integer> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Integer;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
