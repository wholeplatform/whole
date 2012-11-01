package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class LongIntegerAdapter extends AbstractEntityAdapter implements
		LongInteger {
	private static final long serialVersionUID = 1;

	public LongIntegerAdapter(IEntity implementor) {
		super(implementor);
	}

	public LongIntegerAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LongInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.LongInteger;
	}

	public long getValue() {
		return wLongValue();
	}

	public void setValue(long value) {
		wSetValue(value);
	}
}
