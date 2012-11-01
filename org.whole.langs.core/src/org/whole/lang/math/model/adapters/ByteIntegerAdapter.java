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
public class ByteIntegerAdapter extends AbstractEntityAdapter implements
		ByteInteger {
	private static final long serialVersionUID = 1;

	public ByteIntegerAdapter(IEntity implementor) {
		super(implementor);
	}

	public ByteIntegerAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ByteInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ByteInteger;
	}

	public byte getValue() {
		return wByteValue();
	}

	public void setValue(byte value) {
		wSetValue(value);
	}
}
