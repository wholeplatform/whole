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
public class BigIntegerAdapter extends AbstractEntityAdapter implements
		BigInteger {
	private static final long serialVersionUID = 1;

	public BigIntegerAdapter(IEntity implementor) {
		super(implementor);
	}

	public BigIntegerAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BigInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.BigInteger;
	}

	public java.math.BigInteger getValue() {
		return (java.math.BigInteger) wGetValue();
	}

	public void setValue(java.math.BigInteger value) {
		wSetValue((Object) value);
	}
}
